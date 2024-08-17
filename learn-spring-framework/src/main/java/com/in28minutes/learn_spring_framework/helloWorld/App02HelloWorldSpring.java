package com.in28minutes.learn_spring_framework.helloWorld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

    public static void main(String[] args) {

        try(
            //1- Launch a Spring Context
            var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        ) {
            //2- Configure the things we want Spring to manage - We can do it through a @Configuration Class
            //Then we created a name method - @Bean

            //We can get the bean, managed by Spring, through the context
            System.out.println(context.getBean("name")); //Get the bean through te method's identifier
            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("person"));
            System.out.println(context.getBean("address1"));

            //To retrieve a bean, you can also use its type.
            //I have two beans of the same type, soy, I retrieve it by it name and type.
            System.out.println(context.getBean("address2", HelloWorldConfiguration.Address.class));
            //I can annotate a beam as primary, to avoid exception when beams of the same type
            System.out.println(context.getBean(HelloWorldConfiguration.Address.class));

            System.out.println(context.getBean("person2MethodCall"));
            System.out.println(context.getBean("person3Parameters"));
            // getBeanDefinitionNames() gets all bean names
            /* Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println); */
            //println is used as method reference
            System.out.println(context.getBean("person4QualifierParameters"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
