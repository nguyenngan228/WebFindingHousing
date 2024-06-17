/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.controllers;

import com.ndtn.pojo.Imageprofile;
import com.ndtn.pojo.Typeimage;
import com.ndtn.pojo.User;
import com.ndtn.service.ImageProfileService;
import com.ndtn.service.TypeImageService;
import com.ndtn.service.UserService;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author thanh
 */
@RestController
@RequestMapping("/api")
public class ApiImageProfileController {

    @Autowired
    private UserService userService;

    @Autowired
    private ImageProfileService imgProService;

    @Autowired
    private TypeImageService typeService;

    @PostMapping(path = "/imgprofile_create/", consumes = {
        MediaType.APPLICATION_JSON_VALUE,
        MediaType.MULTIPART_FORM_DATA_VALUE
    })
    @CrossOrigin
    public ResponseEntity<String> addImgProfile(@RequestParam Map<String, String> params,
            @RequestPart MultipartFile file, @RequestPart MultipartFile[] imageRow, @RequestPart MultipartFile[] imageRoom) {
        Typeimage type1 = this.typeService.getTypeImgById(1);
        Typeimage type2 = this.typeService.getTypeImgById(2);
        User u = userService.addUser(params, file);
        for (MultipartFile f : imageRow) {
            Imageprofile imgRow = imgProService.addImage(u, f, type1);
        }
        for (MultipartFile f : imageRoom) {
            Imageprofile imgRoom = imgProService.addImage(u, f, type2);
        }

        return new ResponseEntity<>("Thanh cong", HttpStatus.CREATED);
    }

}
