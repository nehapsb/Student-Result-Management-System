package com.management.studentmanegement.validator;

import org.springframework.stereotype.Component;

@Component
public interface ValidationService<T> {
    public boolean validateData(T data);
}
