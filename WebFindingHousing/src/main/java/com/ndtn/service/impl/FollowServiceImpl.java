/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.service.impl;

import com.ndtn.pojo.Follow;
import com.ndtn.pojo.User;
import com.ndtn.repository.FollowRepository;
import com.ndtn.repository.UserRepository;
import com.ndtn.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author thanh
 */
@Service
public class FollowServiceImpl implements FollowService {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private FollowRepository followRepo;

    @Override
    public Follow checkFollow(User followerId, User landlordId) {
        return followRepo.checkFollow(followerId, landlordId);
    }


//    @Override
//    public int addFollow(User landlordId) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User user = this.userRepo.getUserByUsername(authentication.getName());
//        Follow fl = new Follow();
//        fl.setFollowerId(user);
//        fl.setLandlordId(landlordId);
//        fl.setFollowed(Boolean.TRUE);
//        return this.followRepo.addFollow(fl);
//    }
    @Override
    public Follow addFollow(User landlordId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.getUserByUsername(authentication.getName());
        Follow fl = new Follow();
        fl.setFollowerId(user);
        fl.setLandlordId(landlordId);
        fl.setFollowed(Boolean.TRUE);
        return this.followRepo.addFollow(fl);
    }

}
