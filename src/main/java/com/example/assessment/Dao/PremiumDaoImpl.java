package com.example.assessment.Dao;

import com.example.assessment.entity.Premium;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PremiumDaoImpl implements PremiumDao{
    EntityManager entityManager;

    public PremiumDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public Premium findById(int id, int id1) {
        TypedQuery<Premium> typedQuery = (TypedQuery<Premium>) entityManager.createQuery("from Premium where coverageId=? and stateId=?");
        Premium premium = (Premium) typedQuery.getResultList();
        return premium;
    }
}
