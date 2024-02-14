package com.example.assessment.service;

import com.example.assessment.Dao.PremiumDao;
import com.example.assessment.Dao.PremiumDaoImpl;
import com.example.assessment.entity.Premium;
import org.springframework.stereotype.Service;

@Service
public class PremiumServiceImpl implements PremiumService{

    PremiumDao premiumDao;

    public PremiumServiceImpl(PremiumDao premiumDao) {
        this.premiumDao = premiumDao;
    }

    @Override
    public Premium getPremium(int id, int id1) {
        return null;
    }
}
