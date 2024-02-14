package com.example.assessment.Dao;

import com.example.assessment.entity.Address;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressDaoImpl implements AddressDao{
EntityManager entityManager;

    public AddressDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Address> getAll() {
        TypedQuery<Address> typedQuery = entityManager.createQuery("from Address",Address.class);
        List<Address> address = typedQuery.getResultList();
        return address;
    }
}
