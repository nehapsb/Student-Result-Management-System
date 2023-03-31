package com.management.studentmanegement.service;

import com.management.studentmanegement.database.DataRepository;
import com.management.studentmanegement.exception.InvalidDataException;
import com.management.studentmanegement.exception.RecordNotFoundException;
import com.management.studentmanegement.model.BaseClass;
import com.management.studentmanegement.validator.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

//@Component
public class DataHandlerService<T extends BaseClass> {

    @Autowired
    private DataRepository<T> dataRepository;

    @Autowired
    private ValidationService<T> validationService;


    public void add(T data) throws InvalidDataException {
        validationService.validateData(data);
        dataRepository.save(data);
    }

    public Iterable<T> getDetails() {
        return dataRepository.findAll();
    }
    public T get(Long id) {
        return dataRepository.findById(id).orElseThrow(() -> new RecordNotFoundException());
    }
}
