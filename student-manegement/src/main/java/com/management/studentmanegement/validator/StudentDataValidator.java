package com.management.studentmanegement.validator;

import com.management.studentmanegement.exception.InvalidDataException;
import com.management.studentmanegement.model.student.StudentProperties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;

@Component("StudentDataValidator")
public class StudentDataValidator implements ValidationService<StudentProperties> {

    @Override
    public boolean validateData(StudentProperties data) {
        if(StringUtils.isEmpty(data.getFirstName()) || StringUtils.isEmpty(data.getLastName())) {
            throw new InvalidDataException("FirstName or LastName cannot be empty");
        }
        if(StringUtils.isEmpty(data.getDateOfBirth()) || getAge(data.getDateOfBirth()) < 10) {
            throw new InvalidDataException("Age cannot be less than 10");
        }

        return false;
    }

    private int getAge(String dateOfBirth) {
        LocalDate today = LocalDate.now();
        LocalDate dob = LocalDate.parse(dateOfBirth);
        Period p = Period.between(dob, today);
        return p.getYears();
    }
}
