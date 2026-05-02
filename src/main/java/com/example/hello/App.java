package com.example.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Hello hello = context.getBean("hello", Hello.class);
        hello.greet();

        ((ClassPathXmlApplicationContext) context).close();
    }
}
