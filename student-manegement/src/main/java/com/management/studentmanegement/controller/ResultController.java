package com.management.studentmanegement.controller;

import com.management.studentmanegement.model.ResultDataModel;
import com.management.studentmanegement.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/result")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @GetMapping
    public Iterable<ResultDataModel> get() {
        return resultService.getAllResultDetails();
    }

    @GetMapping(value = "/id")
    public ResultDataModel get(@RequestParam Long id) {
        return resultService.getResultDetails(id);
    }

    @PostMapping(value = "/save")
    public void save(@RequestBody ResultDataModel resultDataModel) {
        resultService.addResult(resultDataModel);
    }


}
