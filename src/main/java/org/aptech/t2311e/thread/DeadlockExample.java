package org.aptech.t2311e.thread;

class Resource {
    private final String name;

    public Resource(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


public class DeadlockExample {
    // thread1 lock resource A -> lock resource B
    // thread 2 lock resource B -> next step lock resource A

    public static void main(String[] args) throws InterruptedException {
        Resource resourceA = new Resource("Resource A");
        Resource resourceB = new Resource("Resource B");
        Thread t1 = new Thread( () -> {
            synchronized (resourceA){
                System.err.println("Thread1 : lock" + resourceA.getName());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException i) {
//                throw new RuntimeException(e);
                }

                // dead code , wait resourceB release by t2
                synchronized (resourceB){
                    System.err.println("Thread1 : lock" + resourceB.getName());
                }
            }
        });
        Thread t2 = new Thread( () -> {
            synchronized (resourceB){
                System.err.println("Thread2 : lock" + resourceB.getName());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException i) {
//                throw new RuntimeException(e);
                }
                // resource A - t1 , wait thread 1 release A
                synchronized (resourceA){
                    System.err.println("Thread2 : lock" + resourceA.getName());
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.err.println("Programe end !!! not deadlock");

        /*
        fixme:
        Hau qua : Chương trình bị treo  -> memleak do sinh ra nhiều luồng mà không thu hồi thread
        -> Khắc phục
        1. Giữ quy tắc lock
        A -> B -> C
        ko dc phép B -> A

         */
    }

    /*
    1. Nghiệp vụ : nhiều bước, chồng chéo các luồng , các luồng cùng sử dụng 1 resource chung
    vd  : nhập kho , xuất kho , kiểm kho --> tồn khao
    2. Yêu cầu về concurrent (đồng thời - số lượng người dùng cùng sử dụng 1 lúc) user:
      + bài toán admin portal cho danh nghiệp : ccu thấp (1000) -> 100 ccu
      + Bài toán dịch vụ tài chính : 1000000 user -> 100000 ccu
      + Bài toán về dịch vụ truyền hình  : -> số lượng người dùng lớn
     */
}
