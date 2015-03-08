/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.christianmenz.jaa8playground.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Christian
 */
public class IntroExample {
    
    
    static class Person {
        String name;        
        int age;
        
        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
    
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Homer", 50)); // TODO Do we actually know the age of each Simposns character?
        persons.add(new Person("Marge", 30));
        persons.add(new Person("Bart", 10));
        persons.add(new Person("Lisa", 7));
        persons.add(new Person("Maggie", 1));
        
        // 1st filter the list, we want only the persons older then 9.
        List<Person> filteredPersons = persons.stream().filter(p -> p.age >= 10).collect(Collectors.toList());
        
        // 2nd print each of them. This is just an example, this could also be combined ofc. See 3rd
        filteredPersons.stream().forEach(p -> System.out.println(p.name));
        
        // 3rd, all together        
        persons.stream().filter(p -> p.age >= 10).forEach(p -> System.out.println(p.name));
        
        // 4th, why not do stuff in parallel
        persons.parallelStream().filter(p -> p.age >= 10).forEach(p -> System.out.println(p.name));
        
    }
    
}
