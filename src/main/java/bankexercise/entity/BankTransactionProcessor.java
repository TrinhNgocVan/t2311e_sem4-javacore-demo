package bankexercise.entity;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class BankTransactionProcessor  implements Runnable{
    /*
    Bài toán nhà sản xuất  - producer  và người tiêu dùng consumer
     -> Cân bằng giữa consumer và producer : Queue đứng giữa để cân bằng tải
     -> BlockingQueue để dùng trong trường hợp này

     Nguyên tắc : Nhiều consumer hơn cần thiết
     */

    private BlockingQueue<Transaction> transactionQueue = new LinkedBlockingQueue(100000);

    public BankTransactionProcessor(BlockingQueue<Transaction> transactionQueue) {
        this.transactionQueue = transactionQueue;
    }


    @Override
    public void run() {
        try {
            while (true) {
                Transaction tran = null;
                tran = transactionQueue.take();
                processTransaction(tran);
            }
        } catch (InterruptedException e) {
            // logging
            // fixme  : convention mới  : try with resource
            System.err.println(" Exception ....  , data : . .... ");
            throw new RuntimeException(e);
        }

    }

    private void processTransaction(Transaction tran) throws InterruptedException {
        switch (tran.getTransactionType()) {
            case DEPOSIT:
                tran.getTo().deposit(tran.getAmount());
                break;
            case WITHDRAW:
                tran.getTo().withdraw(tran.getAmount());
                break;
            case TRANSFER:
                tran.getFrom().transfer(tran.getTo(), tran.getAmount());
                break;
        }
    }

    public static void main(String[] args) {
    BlockingQueue<Transaction> queue = new LinkedBlockingQueue<>();
    BankAccount account1 = new BankAccount( 5000000L, 1) ;
    BankAccount account2 = new BankAccount( 6000000L, 1) ;
    BankAccount account3 = new BankAccount( 7000000L, 1) ;

    // Quản lý thread nâng cao theo cơ chế threadpool
    ExecutorService executorService = Executors.newFixedThreadPool(5);

    // 1000 producer
    for(int i =0; i < 1000; i++){
        int id = i;
        executorService.submit(() -> {
            Transaction newTransaction = null;
            if(id %3 == 0){
                newTransaction = new Transaction(id,TransactionType.DEPOSIT,null,account1, 50000);
            }
            if(id %3 == 1){
                newTransaction = new Transaction(id,TransactionType.WITHDRAW,account2,null, 50000);
            }
            if(id %3 == 2){
                newTransaction = new Transaction(id,TransactionType.TRANSFER,account2,account3, 50000);
            }
            if(Objects.nonNull(newTransaction)){
                try {
                    queue.put(newTransaction);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    // todo  :  create multiple comsumer by multi thread to handle transaction






    }


}
