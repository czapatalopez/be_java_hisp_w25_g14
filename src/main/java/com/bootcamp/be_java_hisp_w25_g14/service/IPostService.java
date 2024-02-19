package com.bootcamp.be_java_hisp_w25_g14.service;

import com.bootcamp.be_java_hisp_w25_g14.dto.PostDto;

import java.util.List;

public interface IPostService {

    void savePost(PostDto postDto);
    List<PostDto> getAllPosts();

}
