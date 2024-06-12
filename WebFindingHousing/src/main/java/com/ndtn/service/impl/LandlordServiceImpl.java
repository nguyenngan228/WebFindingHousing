/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.service.impl;

import com.cloudinary.utils.ObjectUtils;
import com.ndtn.pojo.Landlordpost;
import com.ndtn.pojo.Post;
import com.ndtn.pojo.Room;
import com.ndtn.pojo.User;
import com.ndtn.repository.ImageRepository;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ndtn.service.LandlordService;
import com.ndtn.repository.LandlordRepository;
import com.ndtn.repository.PostRepository;
import com.ndtn.repository.RoomRepository;
import com.ndtn.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author thanh
 */
@Service
public class LandlordServiceImpl implements LandlordService {

    @Autowired
    private LandlordRepository landLordPostRepo;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private PostRepository postRepo;
    @Autowired
    private RoomRepository roomRepo;
    @Autowired
    private ImageRepository imgRepo;
    

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

}
