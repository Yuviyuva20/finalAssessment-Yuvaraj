package com.example.assessment.service;

import com.example.assessment.Dao.CoveragesDao;
import com.example.assessment.entity.Coverage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoverageServiceImpl implements CoverageService{
    CoveragesDao coveragesDao;

    public CoverageServiceImpl(CoveragesDao coveragesDao) {
        this.coveragesDao = coveragesDao;
    }

    @Override
    public List<Coverage> getAll() {
        return coveragesDao.getAll();
    }

    @Override
    public Coverage findById(int id) {
        return coveragesDao.findById(id);
    }
}
