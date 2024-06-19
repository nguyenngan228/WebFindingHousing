/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.controllers;

import com.ndtn.pojo.Image;
import com.ndtn.pojo.Room;
import com.ndtn.service.ImageService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author thanh
 */
@RestController
@RequestMapping("/api")
public class ApiImageController {
    @Autowired
    private ImageService imgService;
    
//    @PostMapping(path = "/images/", consumes = {
//        MediaType.APPLICATION_JSON_VALUE,
//        MediaType.MULTIPART_FORM_DATA_VALUE
//    })
//    @CrossOrigin
//    public ResponseEntity<Image> addImage(@RequestParam Map<String, String> params, @RequestPart MultipartFile img) {
//        Room r = new Room();
//        r.setId(Integer.parseInt(params.get("roomId")));
//        Image p = this.imgService.addImage(params,img);
//        return new ResponseEntity<>(p, HttpStatus.CREATED);
//    }
    
    @GetMapping("/rooms/{roomId}/images")
    @CrossOrigin
    public ResponseEntity<List<Image>> getImage(@PathVariable("roomId")int roomId){
        return new ResponseEntity<>(this.imgService.getImages(roomId),HttpStatus.OK);
    }

    
}
