package org.aptech.t2311e;



public class Stringgg {
    /*
    Immutable Object vs mutable Object
    String : immutable
    adv : thread-safe
    disadv : bad memory and cpu

     */
    public static void main(String[] args) {


//        StringBuilderDemo();
        StringBufferDemo();
    }

    public static void StringBuilderDemo(){
        // mutable , bat dong bo , not thread-safe
        System.err.println("run ham");
        long startTime  = System.currentTimeMillis();
        String x = "";
        for(int i =1; i <= 1000000 ; i ++){
            x = x + "1";
        }
        long processTime  = (System.currentTimeMillis() - startTime);
//        System.err.println("x : " + x);
        System.err.println("Thoi gian thuc thi pan1 : " + processTime);

//        long startTime  = System.currentTimeMillis();
//        StringBuilder x1 = new StringBuilder();
//        for(int i =1; i <= 2000000000 ; i ++){  // 2000
//            x1.append("");
//        }
//        long  processTime  = (System.currentTimeMillis() - startTime)  ;
////        System.err.println("x1 : "+x1);
//        System.err.println("Thoi gian thuc thi pan1 : " + processTime);

    }
    public static void StringBufferDemo(){
        // mutable, synchronized, thread-safe
        Long startTime = System.currentTimeMillis();
        StringBuffer x1 = new StringBuffer();
        for(int i =1; i <= 2000000000 ; i ++){  // 2000
            x1.append("1");
        }
        long  processTime  = (System.currentTimeMillis() - startTime)  ;
        System.err.println("x1 : "+x1.toString());
        System.err.println("Thoi gian thuc thi pan1 : " + processTime);

    }





}
