/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.service.impl;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ndtn.pojo.Imageprofile;
import com.ndtn.pojo.Typeimage;
import com.ndtn.pojo.User;
import com.ndtn.repository.ImageProfileRepository;
import com.ndtn.service.ImageProfileService;
import com.ndtn.service.ImageService;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author thanh
 */
@Service
public class ImageProfileServiceImpl implements ImageProfileService{
    @Autowired
    private ImageProfileRepository imgProRepo;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public Imageprofile addImage(User user, MultipartFile file, Typeimage typeId) {
        Imageprofile image = new Imageprofile();
        image.setUserId(user);
        image.setTypeId(typeId);
        if (!file.isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                image.setImage(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(ImageService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.imgProRepo.addImagePro(image);
    }

    

    
    
}
