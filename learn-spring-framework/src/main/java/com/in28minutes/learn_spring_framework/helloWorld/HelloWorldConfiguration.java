package com.in28minutes.learn_spring_framework.helloWorld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class HelloWorldConfiguration {
    //Here we define beans (what spring manages)

    public record Person(String name, int age, Address address) {};
    public record Address(String street, String city) {};

    //Indicates that a method produces a bean to be managed by the Spring container
    @Bean
    public String name() {
        return "Ranga";
    }
    // The default name of the bean is the method's name
    @Bean
    public int age() {
        return 15;
    }

    @Bean
    @Primary
    public int number() {
        return 10;
    }

    @Bean
    public Person person() {
        return new Person("Ravi", 20, new Address("Main Street", "New York"));
    }

    @Bean(name = "address1") //The name attribute allows u to change the name of the bean
        public Address address() {
        return new Address("Baker Street", "London");
    }

    @Bean (name = "address2")
    @Primary // Indicates the primary bean when multiple beans of the same type are present for autowiring.
    public Address address2() {
        return new Address("Saraza 511", "CABA");
    }

    @Bean(name = "address3")
    @Qualifier("address3Qualifier")
    public Address address3() {
        return new Address("Calle 12", "La Plata");
    }

    @Bean (name = "address4")
    public Address address4() {
        return new Address("Lincoln", "Kansas City");
    }

    //Related beans. Create beans reusing created beans
    @Bean
    public Person person2MethodCall() {
        return new Person(name(), age(), address());
        // Uses the methods defined before (There's only one)
        // The one that returns Address["Baker Street", "London"];
    }

    @Bean
    public Person person3Parameters(String name, int age, Address address3) {
        return new Person(name, age, address3);
        //In case, there are more than one "Address" Class, it autowires the one marked as @Primary.
        // It wires beans through its Classes, not its parameterNames.
        //In case there are two int and no @Primary annotations, it injects the one with the same method name (age)
    }

    @Bean
    public Person person4QualifierParameters(String name, int age, @Qualifier("address3Qualifier") Address address2) { // name, age, address2(The name of the beans)
        return new Person(name, age, address2); //Use parameters
    }

}
