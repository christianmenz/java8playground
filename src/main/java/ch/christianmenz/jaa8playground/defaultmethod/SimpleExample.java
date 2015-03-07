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
public class SimpleExample {
    
    interface Interface1 {
        
        default void test() {
            System.out.println("-- default test");
        }     
        
        default void test2() {
            System.out.println("-- default test2");
        }
    }
    
    static class Implementation1 implements Interface1 {
        
        public void test2() {
            System.out.println("my own implementation");
        }
                        
    }
    
    
    public static void main(String[] args) {
        Interface1 if1 = new Implementation1();
        
        if1.test();
        if1.test2();
    }
    
}
