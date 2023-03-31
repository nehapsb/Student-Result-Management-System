package com.management.studentmanegement.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "students")
public class StudentProperties extends BaseClass{

    String firstName;
    String lastName;
    LocalDate dateOfBirth;
}
