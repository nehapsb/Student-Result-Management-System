package com.management.studentmanegement.model.course;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter
@Entity
@ToString
@Table(name="courses")
public class CourseProperties extends CourseBaseClass{
    @NotEmpty
    String courseName;
}
