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
public class MultipleInterfaceInheritance1 {
    
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
        // it makes sense this doesn't work, how could Java know which default method to invoke?        
    }
    
    
    public static void main(String[] args) {
        Interface1 if1 = new Implementation1();
        
        if1.test();       
    }
    
}
