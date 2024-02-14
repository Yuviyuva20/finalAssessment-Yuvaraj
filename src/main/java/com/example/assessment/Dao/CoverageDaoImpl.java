package com.example.assessment.Dao;

import com.example.assessment.entity.Address;
import com.example.assessment.entity.Coverage;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CoverageDaoImpl implements CoveragesDao{

    EntityManager entityManager ;

    public CoverageDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Coverage> getAll() {
        TypedQuery<Coverage> typedQuery = entityManager.createQuery("from Coverage ",Coverage.class);
        List<Coverage> coverages = typedQuery.getResultList();
        return coverages;
    }

    @Override
    public Coverage findById(int id) {
        return entityManager.find(Coverage.class,id);
    }
}
