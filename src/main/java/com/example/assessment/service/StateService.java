package com.example.assessment.service;

import com.example.assessment.entity.State;

import java.util.List;

public interface StateService {
    List<State> getAll();

    State findById(int id);
}
