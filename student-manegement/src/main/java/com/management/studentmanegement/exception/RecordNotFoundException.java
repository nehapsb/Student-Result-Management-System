package com.management.studentmanegement.exception;

public class RecordNotFoundException extends RuntimeException{

    public RecordNotFoundException() {
        super();
    }
    public RecordNotFoundException(String message){
        super(message);
    }
    public RecordNotFoundException(Throwable throwable){
        super(throwable);
    }
    public RecordNotFoundException(String message, Throwable throwable){
        super(message, throwable);
    }
}
