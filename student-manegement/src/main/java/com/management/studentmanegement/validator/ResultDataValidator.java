package com.management.studentmanegement.validator;

import com.management.studentmanegement.exception.InvalidDataException;
import com.management.studentmanegement.exception.RecordNotFoundException;
import com.management.studentmanegement.model.ResultDataModel;
import com.management.studentmanegement.service.CourseService;
import com.management.studentmanegement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component("ResultDataValidator")
public class ResultDataValidator implements ValidationService<ResultDataModel> {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @Override
    public boolean validateData(ResultDataModel data) {
        if(Objects.isNull(data.getCourseId())|| Objects.isNull(data.getStudentId()) || Objects.isNull(data.getGrade())) {
            throw new InvalidDataException("Invalid Request for Result");
        }
        Long studentId = data.getStudentId();
        try {
            studentService.getStudentDetails(studentId);
        } catch (RecordNotFoundException exception) {
            throw new InvalidDataException("Invalid Student id");
        }
        Long courseId = data.getCourseId();
        try {
            courseService.getCourse(courseId);
        } catch (RecordNotFoundException exception) {
            throw new InvalidDataException("Invalid Course id");
        }
        return true;
    }
}
