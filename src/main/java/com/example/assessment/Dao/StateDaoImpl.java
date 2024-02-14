package com.example.assessment.Dao;

import com.example.assessment.entity.Address;
import com.example.assessment.entity.State;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StateDaoImpl implements StateDao{

    EntityManager entityManager;

    public StateDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<State> getAll() {
        TypedQuery<State> typedQuery = entityManager.createQuery("from State",State.class);
        List<State> state = typedQuery.getResultList();
        return state;
    }

    @Override
    public State findById(int id) {
        return entityManager.find(State.class,id);
    }
}
