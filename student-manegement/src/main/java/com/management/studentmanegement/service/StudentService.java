package com.management.studentmanegement.service;

import com.management.studentmanegement.database.DataRepository;
import com.management.studentmanegement.exception.InvalidDataException;
import com.management.studentmanegement.exception.RecordNotFoundException;
import com.management.studentmanegement.model.StudentProperties;
import com.management.studentmanegement.validator.ValidationService;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.inject.Inject;

@Component
public class StudentService {

    private DataRepository<StudentProperties> dataRepository;
    private ValidationService<StudentProperties> validationService;
    @Inject
    public StudentService(DataRepository<StudentProperties> dataRepository,
                          @Qualifier("StudentDataValidator") ValidationService<StudentProperties> validationService) {
        this.dataRepository = dataRepository;
        this.validationService = validationService;
    }

    public void addStudent(StudentProperties studentProperties) throws InvalidDataException {
        validationService.validateData(studentProperties);
        dataRepository.save(studentProperties);
    }

    public Iterable<StudentProperties> getStudentDetails() {
        return dataRepository.findAll();
    }
    public StudentProperties getStudentDetails(Long studentId) {
        return dataRepository.findById(studentId).orElseThrow(() -> new RecordNotFoundException());
    }

}
