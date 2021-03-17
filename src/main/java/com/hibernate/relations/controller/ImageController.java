package com.hibernate.relations.controller;

import com.hibernate.relations.model.Customer;
import com.hibernate.relations.model.Image;
import com.hibernate.relations.service.CustomerService;
import com.hibernate.relations.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/{customerId}")
    public Image save(@PathVariable long customerId, @RequestParam("file") MultipartFile multipartFile) throws IOException {
        Image newImage = new Image();
        newImage.setName(multipartFile.getName());
        newImage.setContent(multipartFile.getBytes());

        return  imageService.save(customerId,newImage);
    }

    @GetMapping(value = "/{imageId}" , produces = MediaType.IMAGE_JPEG_VALUE)
    public ByteArrayResource findById(@PathVariable Long imageId){
        byte[] imageByte = imageService.findById(imageId).getContent();

        return  new ByteArrayResource(imageByte);
    }
}
