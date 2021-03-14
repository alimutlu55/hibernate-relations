package com.hibernate.relations.controller;

import com.hibernate.relations.model.Address;
import com.hibernate.relations.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public Address save(@RequestBody Address address){
        return  addressService.save(address);
    }
    @DeleteMapping
    public void delete(@RequestBody Address address){
        addressService.delete(address);
    }
    @GetMapping("/{id}")
    public Address findById(@PathVariable Long id){
        return  addressService.findById(id);
    }
}
