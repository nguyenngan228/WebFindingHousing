/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.service;

import com.ndtn.pojo.Landlord;
import com.ndtn.pojo.Landlordpost;
import com.ndtn.pojo.Post;
import com.ndtn.pojo.Room;
import com.ndtn.pojo.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author thanh
 */
public interface LandlordService {
    List<Landlordpost> getLandlordPost(Map<String, String> params);
    Landlordpost addLandlordPost(Post post,Room room);
    Landlordpost getPostById(int id);
    Landlord addLandlord(User user,Map<String,String> params);
    List<Landlordpost> getPostByUserId(int id);
}
