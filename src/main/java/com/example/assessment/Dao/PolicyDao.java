package com.example.assessment.Dao;

import com.example.assessment.entity.Policy;

import java.util.List;

public interface PolicyDao {
    List<Policy> getAll();

    Policy save(Policy policyHolder);

    Policy  findById(int id);
}
