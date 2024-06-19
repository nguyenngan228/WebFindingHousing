/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.repository;

import com.ndtn.pojo.Image;
import java.util.List;

/**
 *
 * @author thanh
 */
public interface ImageRepository {
    Image addImage(Image img);
    List<Image> getImages(int roomId);
}
