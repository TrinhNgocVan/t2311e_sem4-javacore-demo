package org.aptech.t2311e.collection;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MyCustumArrayListDemo<E> implements Iterable<E> {
    private Object[] elements;
    private int size;
    public static final int DEFAULT_CAPACITY = 10;


    public MyCustumArrayListDemo() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    // check size
    public int size(){
        return size;
    }
    // check list empty
    public boolean isEmpty(){
        return size == 0;
    }

    // add element in last of arraylist
    // Reflection
    public  void add (E element){
        // extend capactity
        /*
         4 phan tu , capactity  = 4 -> add 1 element  => index out of bound
         khi nao can mo rong  => mo rong list
         */
        ensureCapacity(size+1);
        elements[size +1] = element;
    }

    // insert new element into specific index
    // 2 add function : da hinh
    public void add(int index, E element) throws CustomException {
//        // validate : check index valid
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("index : " + index + " , size : " + size);
        }

        ensureCapacity(size+1);
        for(int i  = size; i > index ; i--){
            elements[i] = elements[i-1];
        }
        elements[index] = element;
        //aspect
        size ++;

        // validate index  -> check capactity -> set orther element
        // -> set new element in list -> increase size
    }

    @SuppressWarnings("unchecked")
    public E get(int index){

        return (E) elements[index];
    }

    public void set(int index, E element){
        elements[index] = element;
    }

    @SuppressWarnings("unchecked")
    public E remove(int index){
        E removeValue  = (E) elements[index];
       for(int i= index ; i < size-1; i++){
           elements[i] = elements[i+1];
       }
       elements[--size] = null; // 1: decrease size  1 , set last element = null to avoid mem leak
        return removeValue;
       /*
       arr = [a1,a2,a3] , index  =1
       for i = 1; i < 2
       arr[1] = a3  -> [a1,a3]
       * */
    }


    public void clear()
    {
        // c1 -> memleak element[i] memory ko bi mat di -> memleak
//        elements = new Object[DEFAULT_CAPACITY];
//        size = 0;
        // c2
        for (int  i =  0; i < size; i ++){
            elements[i]= null;
        }
        size = 0;
    }

 /*
   Theo doi dong du lieu giao dich thoi gian thuc :  transId, account, amount,timestamp
   1. Luu tru cac giao dich gan nhat trong 24 h cua tat ca tai khoan
   2. Phat hien 5 giao dich trong 1 phut cua cung 1 tai khoan
   3. Cac tai khoan dang nghi  ?? (chuyen tien lien tuc voi so luong giao dich , giao dich co vde)
   4. Top 10 giao dich dang nghi nhat, nhieu canh bao nhat

   VD :
   1. ArrayList,Map,Queue... : neu qua 24h  -> bo ra
   -> ????????????????????
    ArrayList  .-> loc duoc qua 24 h ???
    Queue
    2.Map
    -> HashMap<String-accountId, List<Transactions>>

  */

//    for(int  i = 1; i < 1000000; i++){
//        query table student where studentId = 1
//    }
// 1 query :













    public void addAll(List<E> newElements){
        // recursive O(n) = 2n ()
        for (E newElement : newElements) {
            add(newElement);
        }

        // O(n) = n+1
        ensureCapacity(size + newElements.size());
        for (int i =1; i <= newElements.size();i++){
            elements[size+i] = newElements.get(i);
        }
    }
    private void ensureCapacity(int minCapacity){
        // extend 100% capactity
        if(minCapacity > elements.length){
            // extends
            int newCapactity = elements.length * 2;
            // cap phat dong
            Object[] newArray = new Object[newCapactity];
            for (int i =0; i < size; i++){
                newArray[i] = elements[i];
            }
            elements = newArray;
        }
    }


















    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<E> spliterator() {
        return Iterable.super.spliterator();
    }
}
