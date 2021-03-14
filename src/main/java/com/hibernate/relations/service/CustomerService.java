package com.hibernate.relations.service;

import com.hibernate.relations.model.Customer;
import com.hibernate.relations.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer save(Customer customer){
       return  customerRepository.save(customer);
    }
    public void delete(Customer customer){
        Customer fetchedCustomer = findById(customer.getId());
        customerRepository.delete(fetchedCustomer);
    }
    public Customer findById(Long id){
        return  customerRepository.findById(id).get();
    }
}
