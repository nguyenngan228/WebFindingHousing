/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.service;

import com.ndtn.pojo.Imageprofile;
import com.ndtn.pojo.Typeimage;
import com.ndtn.pojo.User;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author thanh
 */
public interface ImageProfileService {
    Imageprofile addImage(User user,MultipartFile file, Typeimage typeId);
}
