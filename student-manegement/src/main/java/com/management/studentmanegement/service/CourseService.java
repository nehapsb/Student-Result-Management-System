package com.management.studentmanegement.service;

import com.management.studentmanegement.database.DataRepository;
import com.management.studentmanegement.exception.RecordAlreadyExistingException;
import com.management.studentmanegement.exception.RecordNotFoundException;
import com.management.studentmanegement.model.CourseProperties;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.Optional;

@Component
public class CourseService {

    private DataRepository<CourseProperties> dataRepository;

    @Inject
    public CourseService(DataRepository<CourseProperties> dataRepository) {
        this.dataRepository = dataRepository;
    }

    public void addStudent(CourseProperties studentProperties) throws RecordAlreadyExistingException {
        dataRepository.save(studentProperties);
    }

    public void updateStudentDetails(CourseProperties studentProperties) {
        dataRepository.save(studentProperties);
    }

    public CourseProperties getStudentDetails(long studentId) {
        return dataRepository.findById(studentId).orElseThrow(() -> new RecordNotFoundException());
    }
    public void deleteStudent(long id) {
        dataRepository.deleteById(id);
    }
}
