package com.example.assessment.service;

import com.example.assessment.Dao.PolicyDao;
import com.example.assessment.entity.Policy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyServiceImpl implements PolicyService {
    PolicyDao policyDao;

    public PolicyServiceImpl(PolicyDao policyDao) {
        this.policyDao = policyDao;
    }


    int amount;

    @Override
    public List<Policy> getAll() {
        return policyDao.getAll();
    }

    @Override
    public Policy save(Policy policyHolder) {
        return policyDao.save(policyHolder);
    }

    @Override
    public Policy findById(int id) {
        return policyDao.findById(id);
    }

    public int getAmount(String[] coverageIDs, String stateID) {
        for (String c : coverageIDs) {
            if ((c.equalsIgnoreCase("1")) && (stateID.equalsIgnoreCase("1"))) {
                amount = amount + 5;
            }
            if ((c.equalsIgnoreCase("1")) && (stateID.equalsIgnoreCase("2"))) {
                amount = amount + 2;
            }
            if ((c.equalsIgnoreCase("1")) && (stateID.equalsIgnoreCase("3"))) {
                amount = amount + 3;
            }
            if ((c.equalsIgnoreCase("2")) && (stateID.equalsIgnoreCase("1"))) {
                amount = amount + 4;
            }
            if ((c.equalsIgnoreCase("2")) && (stateID.equalsIgnoreCase("2"))) {
                amount = amount + 6;
            }
            if ((c.equalsIgnoreCase("2")) && (stateID.equalsIgnoreCase("3"))) {
                amount = amount + 3;
            }
            if ((c.equalsIgnoreCase("3")) && (stateID.equalsIgnoreCase("1"))) {
                amount = amount + 3;
            }
            if ((c.equalsIgnoreCase("3")) && (stateID.equalsIgnoreCase("2"))) {
                amount = amount + 5;
            }
            if ((c.equalsIgnoreCase("3")) && (stateID.equalsIgnoreCase("3"))) {
                amount = amount + 1;
            }
        }
            return amount;

    }
}
