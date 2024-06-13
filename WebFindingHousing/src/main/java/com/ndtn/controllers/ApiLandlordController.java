/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.controllers;

import com.ndtn.pojo.Landlordpost;
import com.ndtn.pojo.Post;
import com.ndtn.pojo.Room;
import com.ndtn.service.ImageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ndtn.service.LandlordService;
import com.ndtn.service.PostService;
import com.ndtn.service.RoomService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author thanh
 */
@RestController
@RequestMapping("/api")
public class ApiLandlordController {

    @Autowired
    private LandlordService landlordPostService;
    @Autowired
    private PostService postService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private ImageService imgService;

    @GetMapping("/landlordposts/")
    @CrossOrigin
    public ResponseEntity<List<Landlordpost>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.landlordPostService.getLandlordPost(params), HttpStatus.OK);
    }
    
    
    
    @GetMapping(path = "/landlordposts/{landlordpostId}/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Landlordpost> retrieve(@PathVariable(value = "landlordpostId") int id) {
        return new ResponseEntity<>(this.landlordPostService.getPostById(id), HttpStatus.OK); 
    }

    
    @PostMapping(path = "/landlordposts_create/", consumes = {
        MediaType.APPLICATION_JSON_VALUE,
        MediaType.MULTIPART_FORM_DATA_VALUE
    })
    @CrossOrigin
    public ResponseEntity<Landlordpost> addLandlordPost(@RequestParam Map<String, String> params,
        @RequestPart MultipartFile[] file) 
    {

        Post post = postService.addPost(params);
        Room room = roomService.addRoom(params);

        for (MultipartFile f : file) {
            imgService.addImage(room, f);
        }

        Landlordpost landlordPost = landlordPostService.addLandlordPost(post, room);

        return new ResponseEntity<>(landlordPost, HttpStatus.CREATED);
    }
    
    
    


}
