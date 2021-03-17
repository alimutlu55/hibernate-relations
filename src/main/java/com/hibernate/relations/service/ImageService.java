package com.hibernate.relations.service;

import com.hibernate.relations.model.Customer;
import com.hibernate.relations.model.Image;
import com.hibernate.relations.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private CustomerService customerService;

    public Image save(Long customerId,Image image){
        Customer customer = customerService.findById(customerId);
        image.setCustomer(customer);
        return  imageRepository.save(image);
    }

    public void delete(Image image){
        Image fetchedImage = findById(image.getId());
        imageRepository.delete(image);
    }

    public Image findById(Long id){
        return  imageRepository.findById(id).get();
    }
}
