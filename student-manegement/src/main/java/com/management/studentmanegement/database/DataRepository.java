package com.management.studentmanegement.database;

import com.management.studentmanegement.model.student.StudentBaseClass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository(value = "student")
public interface DataRepository<T extends StudentBaseClass> extends CrudRepository<T, Long> {}
