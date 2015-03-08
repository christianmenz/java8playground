/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.christianmenz.jaa8playground.defaultmethod;

/**
 *
 * @author Christian
 */
public class MultipleInterfaceInheritance4 {
    
    interface Interface1 {
        
        default void test() {
            System.out.println("-- 1");
        }                  
    }
    
    interface Interface2 {
        
        default void test() {
            System.out.println("-- 2");
        }     
        
      
    }
    
    static class Implementation1 implements Interface1, Interface2 {
        // Java also knows what to do when we explicitly implement the method        
        // But what if I want to actually select Interface1.test()?
        public void test() {
            Interface1.super.test();
        }
    }
    
    
    public static void main(String[] args) {
        Interface1 if1 = new Implementation1();
        
        if1.test();       
    }
    
}
