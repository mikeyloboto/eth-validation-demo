package com.evilbas.ethvalidationdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.evilbas.ethverify.service.Verifier;

@Configuration
@PropertySource("classpath:application.properties")
public class ValidatorConfig {
    @Value("${address}")
    String address;

    @Value("${contractAddress}")
    String contractAddress;

    @Bean
    public Verifier verifier() {
        return Verifier.builder().address(address).contractAddress(contractAddress).build();
    }
}
