package com.example.assessment.service;

import com.example.assessment.entity.Coverage;

import java.util.List;

public interface CoverageService {

    List<Coverage> getAll();

    Coverage findById(int id);
}
