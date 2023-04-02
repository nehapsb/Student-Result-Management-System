package com.management.studentmanegement.validator;

import com.management.studentmanegement.model.course.CourseProperties;
import com.management.studentmanegement.model.result.ResultDataModel;
import com.management.studentmanegement.model.student.StudentProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ValidationConfig {

    @Primary
    @Bean
    public ValidationService<StudentProperties> studentPropertiesValidationService() {
        return new StudentDataValidator();
    }
    @Bean
    public ValidationService<CourseProperties> coursePropertiesValidationService() {
        return new CourseDataValidator();
    }
    @Bean
    public ValidationService<ResultDataModel> resultPropertiesValidationService() {
        return new ResultDataValidator();
    }

}
