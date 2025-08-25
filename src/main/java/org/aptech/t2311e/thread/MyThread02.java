package org.aptech.t2311e.thread;



// priority hon Thread
/*
Inteface hỗ trợ đa kế thừa : 1 class có thể implement nhiều interface
Class chỉ hỗ trợ đơn kế thừa : 1 class chỉ có thể extend 1 class khác
 */
public class MyThread02 implements Runnable{
    MyStudentService studentService;

    public MyThread02(MyStudentService studentService) {
        this.studentService = studentService;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        studentService.addStudent();
        System.err.println("Hello from "+ Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        MyStudentService myStudentService = new MyStudentService();
        Thread t = new Thread(new MyThread02(myStudentService));
        t.start();
        t.join(); // wait thread complete
        System.out.println("Thread t run success");
    }
}
