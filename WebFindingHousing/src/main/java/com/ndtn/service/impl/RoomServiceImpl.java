/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.service.impl;

import com.ndtn.pojo.Image;
import com.ndtn.pojo.Room;
import com.ndtn.pojo.User;
import com.ndtn.repository.RoomRepository;
import com.ndtn.repository.UserRepository;
import com.ndtn.service.RoomService;
import com.ndtn.service.UserService;
import java.math.BigDecimal;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author thanh
 */
@Service
public class RoomServiceImpl implements RoomService{
    @Autowired
    private RoomRepository roomRepo;
    @Autowired
    private UserRepository userRepo;

    @Override
    public Room addRoom(Map<String, String> params) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.getUserByUsername(authentication.getName());
//        User user = userService.getUserByUsername(principal.getName());
        Room u = new Room();
        u.setUserId(user);
        u.setName(params.get("name"));
        u.setAddress(params.get("address"));
        u.setMaxOccupants(Integer.parseInt(params.get("maxoccupants")));
        u.setPrice(params.get("price"));
        u.setLatitude(BigDecimal.valueOf(Long.parseLong(params.get("latitude"))));
        u.setLongitude(BigDecimal.valueOf(Long.parseLong(params.get("longitude"))));
        return this.roomRepo.addRoom(u);

//        for (MultipartFile f : file) {
//            Image img = new Image();
//            img.setRoomId(u);
//            img.setFile(f);
//            imgService.addImage(img);
//        }
    }

    
    
}
