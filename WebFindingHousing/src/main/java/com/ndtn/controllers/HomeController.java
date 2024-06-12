/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.controllers;


import com.ndtn.service.PostService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author thanh
 */
@Controller
@ControllerAdvice
@PropertySource("classpath:configs.properties")
public class HomeController {
    @Autowired
    private PostService postService;
//    @Autowired
//    private AreasService areService;
//    @Autowired
//    private Environment env;
    
    
//    @ModelAttribute
//    public void commonAttr(Model model){
//        model.addAttribute("areas",this.areService.getAreas());
//    }
//    
    @RequestMapping("/")
    @CrossOrigin
    public String index(Model model,
            @RequestParam Map<String, String> params) {
        
//        model.addAttribute("posts", this.postService.getPost(params));
        return "index";
    
    }
}
