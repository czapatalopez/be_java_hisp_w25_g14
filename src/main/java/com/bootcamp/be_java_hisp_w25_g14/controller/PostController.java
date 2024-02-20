package com.bootcamp.be_java_hisp_w25_g14.controller;

import com.bootcamp.be_java_hisp_w25_g14.dto.PostDto;
import com.bootcamp.be_java_hisp_w25_g14.service.IPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/products")
public class PostController {

    private IPostService postService;

    public PostController(IPostService postService) {
        this.postService = postService;
    }

    @GetMapping("/getAllPosts")
    public ResponseEntity<?> findAllPosts(){
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getFollowedPostsLastTwoWeeks(@PathVariable Integer userId, @RequestParam(required = false) String order){
        return new ResponseEntity<>(postService.getFollowedPostsByUserLastTwoWeeks(userId,order),HttpStatus.OK);
    }


    @PostMapping("/post")
    public ResponseEntity<?> savePost(@RequestBody PostDto postDto){
        return new ResponseEntity<>(postService.savePost(postDto,false), HttpStatus.OK);
    }

    @PostMapping("/promo-post")
    public ResponseEntity<?> createPromoPost(@RequestBody PostDto promoPostDto){
        return new ResponseEntity<>(postService.savePost(promoPostDto, true),HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getAmountOfPromoProductsById(@RequestParam Integer user_id){
        return new ResponseEntity<>(postService.getAmountOfPromoProductsById(user_id), HttpStatus.OK);
    }


}
