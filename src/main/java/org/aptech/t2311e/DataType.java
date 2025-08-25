package org.aptech.t2311e;

import java.util.ArrayList;
import java.util.List;

public class DataType {
    /*
    1. primitive data type (nguyen thu)
    luu tru gia tri bo nho, save in stack memory
    default value : 0, 0.0 , false .
    cap phat bo nho : cap phat tinh

    2. reference data type (tham chieu)
     luu tru dia chi tham chieu den doi tuong,save in heap memory
    default value : null
    cap phat bo nho : cap phat dong

    : class , interface, object , enum , collection (ArrayList, Linkedlist, Map, Set...)





     */
   // cap phat tinh :  vuot qua bo nho  -> cap phat lai (xoa bo nho cu di  , tao lai bo nho moi)
    // cap phat dong : vuot qua bo nho  -> ko can cap phat lai ma co the thay doi bo nho

    //  ram  :    #####<xvalue>#####################################################
               // ##################################################################
              // ######<newxvaluenewxvaluenewxvalue>####################################################

     /*
     HEAP VS STACK

      */
//    byte b;  // 1 byte
//    short s; // 2
//    int x ; // 4
//    long y; // 8
//    float z; // 32
//    double a; // 64
//    char chazz; // 2
//    boolean isTrue; // 1 bit

//     int a  = 10;
//     double b  = (double) a;
//     int c = (int) b;
//
//     List<String> x = new ArrayList<>();

//    Byte b;  // 1 byte
//    Short s; // 2
//    Integer x ; // 4
//    Long y; // 8
//    Float z; // 32
//    Double a; // 64
//    Character chazz; // 2
//    Boolean isTrue; // 1 bit

      Integer x   = 5; // Autoboxing : tu dong gan 1 gia tri nguyen thuy  -> bien kieu du lieu tham chieu
     int y = x;   // Unboxing
}
