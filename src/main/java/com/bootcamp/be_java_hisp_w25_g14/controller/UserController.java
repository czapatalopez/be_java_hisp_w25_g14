package com.bootcamp.be_java_hisp_w25_g14.controller;

import com.bootcamp.be_java_hisp_w25_g14.dto.MessageDto;
import com.bootcamp.be_java_hisp_w25_g14.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private IUserService userService;


    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> addFollow(@PathVariable Integer userId, @PathVariable Integer userIdToFollow){
        this.userService.addFollowe(userId,userIdToFollow);
        return new ResponseEntity<>(new MessageDto("Follow successfully",""), HttpStatus.OK);
    }
}