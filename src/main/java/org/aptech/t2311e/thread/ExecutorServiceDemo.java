package org.aptech.t2311e.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceDemo {
    public static void main(String[] args) throws InterruptedException {
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(cores);
        // -> create thread pool with 3 thread
        long startTime = System.currentTimeMillis();
        for(int i =1 ; i <= 5000 ; i++){
            int threadId = i ;
            executor.submit(() ->  {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread " + threadId + " chay trong threadName : "+ Thread.currentThread().getName());
            });
        }
        executor.shutdown();

        if(executor.awaitTermination(10, TimeUnit.SECONDS)){
            System.out.println("Run program in "+ (System.currentTimeMillis() - startTime) + " ms");
        }else {
            System.out.println("Program not complete in 10s");
        }




    }
}
