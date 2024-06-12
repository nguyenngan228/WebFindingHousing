/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.controllers;

import com.ndtn.pojo.Image;
import com.ndtn.pojo.Post;
import com.ndtn.pojo.Room;
import com.ndtn.pojo.User;
import com.ndtn.service.ImageService;
import com.ndtn.service.RoomService;
import com.ndtn.service.UserService;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author thanh
 */
@RestController
@RequestMapping("/api")
public class ApiRoomController {

//    @Autowired
//    private ImageService imgService;

    @Autowired
    private RoomService roomService;

//    @PostMapping(path = "/rooms/", consumes = {
//        MediaType.APPLICATION_JSON_VALUE,
//        MediaType.MULTIPART_FORM_DATA_VALUE
//    })
//    @ResponseStatus(HttpStatus.CREATED)
//    @CrossOrigin
//    public void create(@RequestParam Map<String, String> params, @RequestPart MultipartFile[] file, Principal principal) {
//
//        User user = userService.getUserByUsername(principal.getName());
//        Room u = new Room();
//        u.setUserId(user);
//        u.setName(params.get("name"));
//        u.setAddress(params.get("address"));
//        u.setMaxOccupants(Integer.parseInt(params.get("maxoccupants")));
//        u.setPrice(params.get("price"));
//        u.setLatitude(BigDecimal.valueOf(Long.parseLong(params.get("latitude"))));
//        u.setLongitude(BigDecimal.valueOf(Long.parseLong(params.get("longitude"))));
//        roomService.addRoom(u);
//
//        for (MultipartFile f : file) {
//            Image img = new Image();
//            img.setRoomId(u);
//            img.setFile(f);
//            imgService.addImage(img);
//        }
//        
//
//    }
    @PostMapping(path="/rooms_create/",produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Room> addPost(@RequestParam Map<String, String> params) {
        Room r = this.roomService.addRoom(params);
        return new ResponseEntity<>(r, HttpStatus.CREATED);
    }
}
