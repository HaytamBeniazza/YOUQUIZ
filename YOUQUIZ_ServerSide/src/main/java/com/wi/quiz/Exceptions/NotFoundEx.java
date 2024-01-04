package com.wi.quiz.Exceptions;

public class NotFoundEx extends RuntimeException{
    public NotFoundEx(String message) {
        super(message);
    }
}