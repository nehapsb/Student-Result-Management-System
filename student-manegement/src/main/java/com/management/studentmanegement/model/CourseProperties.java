package com.management.studentmanegement.model;

import lombok.*;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name="courses")
public class CourseProperties extends BaseClass{
    String courseName;
}
