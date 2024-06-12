/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.service;

import com.ndtn.pojo.Image;
import com.ndtn.pojo.Room;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author thanh
 */
public interface ImageService {
    Image addImage(Room room,MultipartFile file);
}
