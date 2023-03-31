package com.management.studentmanegement.model;

import lombok.*;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name="courses")
public class CourseProperties extends BaseClass{
    String courseName;
}
