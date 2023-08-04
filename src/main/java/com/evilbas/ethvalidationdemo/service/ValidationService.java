package com.evilbas.ethvalidationdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;

import com.evilbas.ethvalidationdemo.domain.ValidationRequest;
import com.evilbas.ethverify.service.Verifier;

@Service
public class ValidationService {
    @Value("${privateKey}")
    String privateKey;

    @Autowired
    Verifier verifier;

    public boolean validate(ValidationRequest request) throws Exception {
        return verifier.verifyUpdate(request.getFileName(), request.getFileHash());
    }

    public void submitValidation(ValidationRequest request) throws Exception {
        verifier.registerVerification(request.getFileName(), request.getFileHash(), Credentials.create(privateKey));
    }
}
