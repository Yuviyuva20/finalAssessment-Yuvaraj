package com.example.assessment.Dao;

import com.example.assessment.entity.State;

import java.util.List;

public interface StateDao {
    List<State> getAll();

    State findById(int id);
}
