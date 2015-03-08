/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.christianmenz.jaa8playground.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Christian
 */
public class ParallelPerformance {

    static class Person {

        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

    }

    public static void main(String[] args) throws InterruptedException {
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < 5000; i++) {
            persons.add(new Person(UUID.randomUUID().toString(), (int) (Math.random() * 100 + 1)));
        }

        // sequential
        long start = System.currentTimeMillis();
        persons.stream().filter(p -> {
            try {
                // whatever we do, it should take a while, else the parallel processing is just overhead
                Thread.sleep(2);
            } catch (InterruptedException e) {
            }
            return p.age >= 50;
        }).forEach(p -> p.name = new StringBuilder(p.name).reverse().toString());

        System.out.printf("Took me %s\n", System.currentTimeMillis() - start);

        // parallel
        start = System.currentTimeMillis();
        persons.parallelStream().filter(p -> {
            try {
                // whatever we do, it should take a while, else the parallel processing is just overhead
                Thread.sleep(2);
            } catch (InterruptedException e) {
            }
            return p.age >= 50;
        }).forEach(p -> p.name = new StringBuilder(p.name).reverse().toString());

        System.out.printf("Took me %s\n", System.currentTimeMillis() - start);
    }
}
