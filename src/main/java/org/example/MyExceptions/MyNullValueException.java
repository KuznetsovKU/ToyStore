package org.example.MyExceptions;

public class MyNullValueException extends NullPointerException{
    public MyNullValueException(String s) {
        super(s);
    }
}
