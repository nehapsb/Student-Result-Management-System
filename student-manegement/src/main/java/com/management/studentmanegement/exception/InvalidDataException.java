package com.management.studentmanegement.exception;

public class RecordAlreadyExistingException extends RuntimeException{

    public RecordAlreadyExistingException() {
        super();
    }
    public RecordAlreadyExistingException(String message){
        super(message);
    }
    public RecordAlreadyExistingException(Throwable throwable){
        super(throwable);
    }
    public RecordAlreadyExistingException(String message, Throwable throwable){
        super(message, throwable);
    }
}
