package com.management.studentmanegement.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository<T> extends CrudRepository<T, Long> {}
