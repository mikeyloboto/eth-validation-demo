package com.evilbas.ethvalidationdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.evilbas.ethvalidationdemo.domain.ValidationRequest;
import com.evilbas.ethvalidationdemo.service.ValidationService;

@RestController
public class ValidationController {

    @Autowired
    ValidationService validationService;

    @PostMapping("/validate")
    public Boolean validate(@RequestBody ValidationRequest validationRequest) throws Exception {
        return validationService.validate(validationRequest);
    }

    @PostMapping("/submit")
    public void submit(@RequestBody ValidationRequest validationRequest) throws Exception {
        validationService.submitValidation(validationRequest);
    }

}
