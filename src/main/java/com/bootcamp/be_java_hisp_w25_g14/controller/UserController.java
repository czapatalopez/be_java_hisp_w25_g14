package com.bootcamp.be_java_hisp_w25_g14.controller;

import com.bootcamp.be_java_hisp_w25_g14.dto.FollowedListResponseDto;
import com.bootcamp.be_java_hisp_w25_g14.dto.MessageDto;
import com.bootcamp.be_java_hisp_w25_g14.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private IUserService userService;

    @GetMapping("/{id}/followers/list/{alphaOrder}")
    public ResponseEntity<?> listSellersFollower(@PathVariable int id,
                                                  @PathVariable String alphaOrder){



        return new ResponseEntity<>(this.userService.listSellersFollowers(id,alphaOrder), HttpStatus.OK);
    }

    @GetMapping("/{id}/followers/list")
    public ResponseEntity<?> listSellersFollowers(@PathVariable int id){

        return new ResponseEntity<>(this.userService.listSellersFollowers(id,""), HttpStatus.OK);
    }

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> addFollow(@PathVariable Integer userId, @PathVariable Integer userIdToFollow){
        this.userService.addFollowe(userId,userIdToFollow);
        return new ResponseEntity<>(new MessageDto("Follow successfully",""), HttpStatus.OK);
    }

    @GetMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> removeFollow(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) {
        this.userService.removeFollow(userId, userIdToUnfollow);
        return new ResponseEntity<>(new MessageDto("Unfollow successfully", ""), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<?>getFollowed(@PathVariable Integer userId){
        return new ResponseEntity<>(this.userService.getFollowedByUser(userId),HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<?> getUserFollowersCount(@PathVariable Integer userId) {
        return new ResponseEntity<>(this.userService.getUserFollowersCount(userId),HttpStatus.OK);
    }
}
