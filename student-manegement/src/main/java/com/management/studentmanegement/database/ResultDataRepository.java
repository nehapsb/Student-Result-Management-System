package com.management.studentmanegement.database;

import com.management.studentmanegement.model.result.ResultBaseClass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "result")
public interface ResultDataRepository<T extends ResultBaseClass> extends CrudRepository<T, Long> {}
