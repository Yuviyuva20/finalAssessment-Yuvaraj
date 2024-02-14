package com.example.assessment.service;

import com.example.assessment.Dao.AddressDaoImpl;
import com.example.assessment.entity.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{
    AddressDaoImpl addressDao;

    public AddressDaoImpl getAddressDao() {
        return addressDao;
    }

    public void setAddressDao(AddressDaoImpl addressDao) {
        this.addressDao = addressDao;
    }

    @Override
    public List<Address> getAll() {
        return  addressDao.getAll();
    }
}
