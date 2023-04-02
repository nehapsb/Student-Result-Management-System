package com.management.studentmanegement.validator;

import com.management.studentmanegement.exception.InvalidDataException;
import com.management.studentmanegement.model.course.CourseProperties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component("CourseDataValidator")
public class CourseDataValidator implements ValidationService<CourseProperties> {

    @Override
    public boolean validateData(CourseProperties data) {
        if(StringUtils.isEmpty(data.getCourseName())) {
            throw new InvalidDataException("Course cannot be empty");
        }
        return true;
    }
}
