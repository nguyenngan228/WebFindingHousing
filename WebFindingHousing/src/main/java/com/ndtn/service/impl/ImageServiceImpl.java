/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ndtn.pojo.Image;
import com.ndtn.pojo.Room;
import com.ndtn.repository.ImageRepository;
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
public class ImageServiceImpl implements ImageService{
    @Autowired
    private ImageRepository imgRepo;
    @Autowired
    private Cloudinary cloudinary;

//    @Override
//    public void addImage(Image img) {
//         if (!img.getFile().isEmpty()) {
//            try {
//                Map res = this.cloudinary.uploader().upload(img.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
//                img.setImage(res.get("secure_url").toString());
//            } catch (IOException ex) {
//                Logger.getLogger(ImageServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        
//        this.imgRepo.addImage(img);
//    }

//    @Override
//    public Image addImage(Map<String, String> params, MultipartFile file) {
//        Room r = new Room();
//        r.setId(Integer.parseInt(params.get("roomId")));
//        Image u = new Image();
//        u.setRoomId(r);
//        if (!file.isEmpty()) {
//            try {
//                Map res = this.cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("resource_type", "auto"));
//                u.setImage(res.get("secure_url").toString());
//            } catch (IOException ex) {
//                Logger.getLogger(ImageServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        
//        
//        return this.imgRepo.addImage(u);
//    }

    @Override
    public Image addImage(Room room, MultipartFile file) {
        Image image = new Image();
        image.setRoomId(room);
        if (!file.isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                image.setImage(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(ImageService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.imgRepo.addImage(image);
    }
    
}
