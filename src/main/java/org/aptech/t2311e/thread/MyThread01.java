package org.aptech.t2311e.thread;

public class MyThread01  extends  Thread {
    MyStudentService studentService;

    public MyThread01(MyStudentService studentService) {
        this.studentService = studentService;
    }

    public void run (){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        studentService.addStudent(); // null pointer exception
        System.err.println("Hello from "+ Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        MyThread01 thread01 = new MyThread01(new MyStudentService());
        thread01.start();
        System.err.println("Thread run success");  // asynchronous
    }
}


class MyStudentService {
    public void addStudent(){
        System.err.println("Run student add service");
    }
}
