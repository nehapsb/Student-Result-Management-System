package com.management.studentmanegement.database;

import com.management.studentmanegement.model.course.CourseBaseClass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "course")
public interface CourseDataRepository<T extends CourseBaseClass> extends CrudRepository<T, Long> {}
