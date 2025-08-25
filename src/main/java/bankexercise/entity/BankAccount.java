package bankexercise.entity;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public    class BankAccount {
    private final long id;
    private long balance;
    private User user;
    private AccountType accountType;

    public BankAccount( long balance, long id) {
        this.accountType = AccountType.VISA;
        this.balance = balance;
        this.id = id;
    }

    //    private volatile  boolean lockFlag = false;
    // ReentrantLock : nếu ko lấy được resource trong 1 khoảng thời gian nhất định -> bỏ cuộc
    private final Lock lock = new ReentrantLock();

    public BankAccount(long id) {
        this.id = id;
    }

    // Solution 1 : synchronized là 1 cơ chế đồng bộ hóa -> đảm bảo tính toàn vẹn về mặt dữ liệu
    // khi nhiều thread hay luồng cùng thao tác trên 1 tài nguyên chung
    /*
    Vd : Server nhận nhiều request 1 lúc (1000 req /s) -> cần phải có cơ chế đa luồng nhằm tăng performance của hệ thống
    -> server có thread khác nhau để xử lý các request khác nhau
    -> Vd :
          + nhận request trừ tiền ở 1 tài khoản A
          + nhận request chuyển tiền từ tài khoản B đến tài khoản A
          + nhận request hạch toán lãi cuối tháng đến tài khoản A (cho số tiền lưu trữ ở tài khoản A).
       Vấn đề : 3 sự kiện trên có thể xảy ra đồng thời
       -> hệ thống có thể nhận 3 yêu cầu cùng lúc  . nếu mà không đồng bộ hóa  (chạy bất đồng bộ) ->
       xung đột tài nguyên (tài khoản A - số dư tk) -> sai nghiệp vụ
     */

    /**
        Todo : Sử dụng từ khóa synchronized
        Ưu điểm  :
        1. Nhất quán dữ liệu  (data consistency)
        Nhược điểm :
        1. Giảm hiệu năng : chỉ 1 thread dc làm việc tại 1 thời điểm  -> Nhiều thread phải chờ để
     được dùng . Nếu trường hợp nhiều quá  -> bottleneck (nghẽn cổ chai)
       2. deadlock : 2 thread chờ lẫn nhau  -> hệ thống treo vĩnh viễn
      A chờ B.fun1() , B chờ A.func2()
        Todo : sử dụng ReentrantLock
       1. linh hoạt hơn
     */

//    private  synchronized boolean deposit(long amount) throws InterruptedException {
//        this.balance += amount;
//        // do something -> still lock this.balance
//        Thread.sleep(1000);
//        return true;
//    };
    public   boolean deposit(long amount) throws InterruptedException {
        if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
            try {
                this.balance += amount;
                System.err.println("Deposit Success , account:  "+id + " , amount : "+ amount);
                return true;
            } finally {
                lock.unlock();
            }
        } else {
            System.err.println("Cannot get lock");
            return false ;
        }
    };
    public   boolean withdraw(long amount) throws InterruptedException {
        if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
            try {
                if(this.balance >= amount){
                    balance -= amount;
                    System.err.println("Withdraw Success , account:  "+id + " , amount : "+ amount);
                    return true;
                }{
                    return false;
                }
            } finally {
                lock.unlock();
            }
        } else {
            System.err.println("Cannot get lock");
            return false ;
        }
    };

    public  boolean transfer(BankAccount target,long amount) throws InterruptedException {
        if (!lock.tryLock(1000, TimeUnit.MILLISECONDS) || target.lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
            return false;
        }
        try {
            if (!(this.balance >= amount)) {
                return false;
            }
            this.balance -= amount;
            target.balance += amount;
            return true;
        } finally {
            target.lock.unlock();
            lock.unlock();
        }
    };


}
