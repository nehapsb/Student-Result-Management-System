package com.management.studentmanegement.exception;

public class InvalidDataException extends RuntimeException{

    public InvalidDataException() {
        super();
    }
    public InvalidDataException(String message){
        super(message);
    }
    public InvalidDataException(Throwable throwable){
        super(throwable);
    }
    public InvalidDataException(String message, Throwable throwable){
        super(message, throwable);
    }
}
