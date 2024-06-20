/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.service.impl;


import com.ndtn.pojo.Landlord;
import com.ndtn.pojo.Landlordpost;
import com.ndtn.pojo.Post;
import com.ndtn.pojo.Room;
import com.ndtn.pojo.User;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ndtn.service.LandlordService;
import com.ndtn.repository.LandlordRepository;

/**
 *
 * @author thanh
 */
@Service
public class LandlordServiceImpl implements LandlordService {

    @Autowired
    private LandlordRepository landLordPostRepo;

    @Autowired
    private LandlordRepository landlordRepo;
    

    @Override
    public List<Landlordpost> getLandlordPost(Map<String, String> params) {
        return this.landLordPostRepo.getLandlordPost(params);
    }

    @Override
    public Landlordpost addLandlordPost(Post post, Room room) {
        Landlordpost p = new Landlordpost();
        p.setPostId(post);
        p.setRoomId(room);
        return landLordPostRepo.addLandlordPost(p);
    }

    @Override
    public Landlordpost getPostById(int id) {
        return this.landLordPostRepo.getPostById(id);
    }

    @Override
    public Landlord addLandlord(User user, Map<String, String> params) {
        
        Landlord landlord = new Landlord();
        landlord.setUserId(user);
        landlord.setAddress(params.get("address"));
        landlord.setPhoneNumber(params.get("phone_number"));
        return this.landlordRepo.addLandlord(landlord);
    }

    @Override
    public List<Landlordpost> getPostByUserId(int id) {
        return this.landlordRepo.getPostByUserId(id);
    }

}
