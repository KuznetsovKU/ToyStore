package org.example.MyExceptions;

public class MyNotIntegerException extends IllegalArgumentException{
    public MyNotIntegerException(String s) {
        super(s);
    }
}
