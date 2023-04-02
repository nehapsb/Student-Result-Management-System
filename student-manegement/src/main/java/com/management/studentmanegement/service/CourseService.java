package com.management.studentmanegement.service;

import com.management.studentmanegement.database.CourseDataRepository;
import com.management.studentmanegement.exception.InvalidDataException;
import com.management.studentmanegement.exception.RecordNotFoundException;
import com.management.studentmanegement.model.course.CourseProperties;
import com.management.studentmanegement.validator.ValidationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class CourseService {

    private CourseDataRepository<CourseProperties> dataRepository;
    private ValidationService<CourseProperties> validationService;

    @Inject
    public CourseService(CourseDataRepository<CourseProperties> dataRepository,
                         @Qualifier("CourseDataValidator") ValidationService<CourseProperties> validationService) {
        this.dataRepository = dataRepository;
        this.validationService = validationService;
    }

    public void addCourse(CourseProperties courseProperties) throws InvalidDataException {
        validationService.validateData(courseProperties);
        dataRepository.save(courseProperties);
    }
    public Iterable<CourseProperties> getAllCourses() {
        return dataRepository.findAll();
    }
    public CourseProperties getCourse(Long courseId) {
        return dataRepository.findById(courseId).orElseThrow(() -> new RecordNotFoundException());
    }
    public void deleteCourse(Long id) {
        dataRepository.deleteById(id);
    }
}
