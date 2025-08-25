package org.aptech.t2311e.thread;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class RaceConditionExample {
    /*
    Race condition : Khi mà nhiều thread cùng truy cập tài nguyên chung (DB,FILE,VARIABLE)
    -> lỗi dữ liệu
     */

}
class Counter {
    int num = 0;
    public  void increment(){
        num++;
    }



    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        // create 2 thread to increment c
        Thread t1 = new Thread(() -> {
            for (int  i = 1; i <= 1000 ; i ++){
                counter.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int  i = 1; i <= 1000 ; i ++){
                counter.increment();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("num value : "+counter.num);
    }
}
