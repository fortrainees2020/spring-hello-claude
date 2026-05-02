package com.example.hello;

public class Hello {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void greet() {
        System.out.println("Hello from Spring: " + message);
    }
}
