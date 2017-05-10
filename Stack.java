/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.Collection;

/**
 *
 * @author Azri Zai
 */
public class Stack<E> {
    
    private java.util.ArrayList<E> list = new java.util.ArrayList<E>();
    
    public void push(E o) {
        list.add(o);
    }
    
    public E pop() {
        E o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }
    
    public E peek() {
        return list.get(getSize() - 1);
    }
    
    public int getSize() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public int max() {
        
//        double max = (Double) list.get(0);
//        int j=0;
//        
//        for (int i=1; i<list.size()-1; i++) {
//            
//            if (max < (Double) list.get(i)) {
//                
//                max = (Double) list.get(i);
//                
//                j=i;
//                
//            }
//            
//        }
        
        int max = 0;
        
        for (int i=1; i<list.size()-1; i++) {
            
            double temp = (Double) list.get(i);
            
            if ((Double) list.get(max) < temp) {
                
                max = i;
                
                
            }
            
        }
        
        //indexName(j);
        
        return max;
        
    }
    
    public E getX(int i) {
        
        return (E) list.get(i);
    }
    
    public E indexName(int i) {
        
        return (E) list.get(i);
    }

    @Override
    public String toString() {
        return "Stack: " + list.toString();
    }
    
    public boolean search (E o) {
        
        if (list.contains(o))
            return true;
        
        else
            return false;
    }
    
}
