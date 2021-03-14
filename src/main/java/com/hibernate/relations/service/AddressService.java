package com.hibernate.relations.service;

import com.hibernate.relations.model.Address;
import com.hibernate.relations.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public Address save(Address address){
        return  addressRepository.save(address);
    }

    public void delete(Address address){
        Address fetchedAddress = findById(address.getId());
        addressRepository.delete(fetchedAddress);
    }

    public Address findById(Long id){
        return  addressRepository.findById(id).get();
    }
}
