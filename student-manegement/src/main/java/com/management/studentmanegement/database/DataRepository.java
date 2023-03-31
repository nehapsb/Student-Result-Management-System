package com.management.studentmanegement.database;

import com.management.studentmanegement.model.BaseClass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface DataRepository<T extends BaseClass> extends CrudRepository<T, Long> {}
