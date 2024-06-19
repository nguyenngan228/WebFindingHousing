/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.service.impl;

import com.ndtn.pojo.District;
import com.ndtn.pojo.Landlord;
import com.ndtn.pojo.Landlordpost;
import com.ndtn.pojo.Post;
import com.ndtn.pojo.Province;
import com.ndtn.pojo.Room;
import com.ndtn.pojo.User;
import com.ndtn.repository.DistrictRepository;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ndtn.service.LandlordService;
import com.ndtn.repository.LandlordRepository;
import com.ndtn.repository.ProvineRepository;
import com.ndtn.repository.WardsRepository;

/**
 *
 * @author thanh
 */
@Service
public class LandlordServiceImpl implements LandlordService {

    @Autowired
    private LandlordRepository landLordPostRepo;
    @Autowired
    private DistrictRepository districtRepo;
    @Autowired
    private WardsRepository wardsRepo;
    @Autowired
    private ProvineRepository provineRepo;
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
        District district = districtRepo.getDistrictById(1);
        Province province = provineRepo.getProvinceById(1);
        Landlord landlord = new Landlord();
        landlord.setUserId(user);
        landlord.setFullName(params.get("full_name"));
        landlord.setStreet(params.get("street"));
        landlord.setPhoneNumber(params.get("phone_number"));
        landlord.setProvince(province);
        landlord.setWard(2);
        landlord.setDistrict(district);
        return this.landlordRepo.addLandlord(landlord);
    }

    @Override
    public List<Landlordpost> getPostByUserId(int id) {
        return this.landlordRepo.getPostByUserId(id);
    }

}
