package com.management.studentmanegement.service;

import com.management.studentmanegement.database.DataRepository;
import com.management.studentmanegement.exception.RecordAlreadyExistingException;
import com.management.studentmanegement.exception.RecordNotFoundException;
import com.management.studentmanegement.model.CourseProperties;
import com.management.studentmanegement.model.ResultDataModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class ResultService {

    private DataRepository<ResultDataModel> dataRepository;

    @Inject
    public ResultService(DataRepository<ResultDataModel> dataRepository) {
        this.dataRepository = dataRepository;
    }

    public void addResult(ResultDataModel studentProperties) throws RecordAlreadyExistingException {
        dataRepository.save(studentProperties);
    }

    public void updateResultDetails(ResultDataModel studentProperties) {
        dataRepository.save(studentProperties);
    }

    public ResultDataModel getResultDetails(long studentId) {
        return dataRepository.findById(studentId).orElseThrow(() -> new RecordNotFoundException());
    }
    public void deleteResult(long id) {
        dataRepository.deleteById(id);
    }
}
