package com.management.studentmanegement.service;

import com.management.studentmanegement.database.DataRepository;
import com.management.studentmanegement.exception.RecordAlreadyExistingException;
import com.management.studentmanegement.exception.RecordNotFoundException;
import com.management.studentmanegement.model.StudentProperties;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.awt.*;

@Component
public class StudentService {

    private DataRepository<StudentProperties> dataRepository;

    @Inject
    public StudentService(DataRepository<StudentProperties> dataRepository) {
        this.dataRepository = dataRepository;
    }


    public void addStudent(StudentProperties studentProperties) throws RecordAlreadyExistingException {

        dataRepository.save(studentProperties);
    }

    public void updateStudentDetails(StudentProperties studentProperties) {
        dataRepository.save(studentProperties);
    }
    public Iterable<StudentProperties> getStudentDetails() {
        return dataRepository.findAll();
    }
    public StudentProperties getStudentDetails(Long studentId) {
        return dataRepository.findById(studentId).orElseThrow(() -> new RecordNotFoundException());
    }
    public void deleteStudent(long id) {
        dataRepository.deleteById(id);
    }
}
