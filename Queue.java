/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.Collections;
import java.util.List;
import java.util.Comparator;

/**
 *
 * @author Azri Zai
 */
public class Queue<E> {
    
    public java.util.LinkedList<E> list = new java.util.LinkedList<E>();
    
    public Queue(E[] e) {
        
        for(int i=0; i<e.length; i++) {
            enqueue(e[i]);
        }
        
    }
    
    public Queue() {
        
        
        
    }
    
    public void enqueue(E e) {
        
        list.addLast(e);
        
    }
    
    public E dequeue() {
        
        return list.removeFirst();
                
    }
    
    public E getElement(int i) {
        
        //E e = list.get(i);
        return (E) list.get(i);
        
    }
    
    public E peek() {
        
        return list.peek();
        
    }
    
    public int getSize() {
        
        return list.size();
    }
    
    public boolean contain(E e){
        
        return list.contains(e);
    }
    
    public boolean isEmpty(){
        
        return list.isEmpty();
    }
    
//    public E maximum() {
//        
//        E max = (E) list.getFirst();
//        E temp = list.get(1);
//        
//        if (max.compareTo(temp))
//        
//    }
    
    @Override
    public String toString() {
        
        return "" + list.toString();
    }
    
    
    
}
