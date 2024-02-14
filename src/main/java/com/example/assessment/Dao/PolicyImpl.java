package com.example.assessment.Dao;

import com.example.assessment.entity.Policy;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PolicyImpl implements PolicyDao {
    EntityManager entityManager;

    public PolicyImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Policy> getAll() {
        TypedQuery<Policy> typedQuery = entityManager.createQuery("from Policy", Policy.class);
        List<Policy> policy = typedQuery.getResultList();
        return policy;
    }

    @Transactional
    @Override
    public Policy save(Policy policyHolder) {
        return entityManager.merge(policyHolder);
    }

    @Override
    public Policy findById(int id) {
        return entityManager.find(Policy.class,id);
    }
}
