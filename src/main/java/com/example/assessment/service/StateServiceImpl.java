package com.example.assessment.service;

import com.example.assessment.Dao.StateDao;
import com.example.assessment.entity.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateServiceImpl implements StateService{
    @Autowired
    StateDao stateDao;

    public StateServiceImpl(StateDao stateDao) {
        this.stateDao = stateDao;
    }

    @Override
    public List<State> getAll() {
        return stateDao.getAll();
    }

    @Override
    public State findById(int id) {
        return stateDao.findById(id);
    }
}
