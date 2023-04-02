package com.management.studentmanegement.service;

import com.management.studentmanegement.database.ResultDataRepository;
import com.management.studentmanegement.exception.RecordAlreadyExistingException;
import com.management.studentmanegement.exception.RecordNotFoundException;
import com.management.studentmanegement.model.Grade;
import com.management.studentmanegement.model.result.ResultDataModel;
import com.management.studentmanegement.model.result.ResultOptions;
import com.management.studentmanegement.validator.ValidationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ResultService {

    private ResultDataRepository<ResultDataModel> dataRepository;
    private ValidationService<ResultDataModel> validationService;
    @Inject
    public ResultService(ResultDataRepository<ResultDataModel> dataRepository,
                         @Qualifier("ResultDataValidator") ValidationService<ResultDataModel> validationService) {
        this.dataRepository = dataRepository;
        this.validationService = validationService;
    }

    public void addResult(ResultDataModel resultDataModel) throws RecordAlreadyExistingException {
        validationService.validateData(resultDataModel);
        dataRepository.save(resultDataModel);
    }

    public void updateResultDetails(ResultDataModel resultDataModel) {
        dataRepository.save(resultDataModel);
    }
    public Iterable<ResultDataModel> getAllResultDetails() {
        return dataRepository.findAll();
    }
    public ResultDataModel getResultDetails(Long studentId) {
        return dataRepository.findById(studentId).orElseThrow(() -> new RecordNotFoundException());
    }
    public List<Grade> getResultOptions() {
        return Arrays.asList(Grade.values());
    }
}
