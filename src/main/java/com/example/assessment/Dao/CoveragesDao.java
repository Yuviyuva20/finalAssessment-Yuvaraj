package com.example.assessment.Dao;

import com.example.assessment.entity.Coverage;

import java.util.List;

public interface CoveragesDao {

    List<Coverage> getAll();

    Coverage findById(int id);
}
