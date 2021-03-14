package com.hibernate.relations.controller;

import com.hibernate.relations.model.Customer;
import com.hibernate.relations.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Customer save(@RequestBody Customer customer){
        return  customerService.save(customer);
    }
    @DeleteMapping
    public void delete(@RequestBody Customer customer){
        customerService.delete(customer);
    }
    @GetMapping("/{id}")
    public Customer findById(@PathVariable Long id){
        return  customerService.findById(id);
    }
}
