package com.example.assessment.service;

import com.example.assessment.entity.Policy;

import java.util.List;

public interface PolicyService {
    List<Policy> getAll();

    Policy save(Policy policyHolder);

    Policy findById(int id);

    int getAmount(String[] coverageIDs, String state);
}
