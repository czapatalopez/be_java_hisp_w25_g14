package com.bootcamp.be_java_hisp_w25_g14.service;

import com.bootcamp.be_java_hisp_w25_g14.dto.PostDto;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.NoFoundException;
import com.bootcamp.be_java_hisp_w25_g14.repository.IPostRepo;
import com.bootcamp.be_java_hisp_w25_g14.utils.ApiMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class PostServiceImp implements IPostService{

    private IPostRepo postRepository;

    public PostServiceImp(IPostRepo postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void savePost(PostDto postDto) {

    }

    @Override
    public List<PostDto> getAllPosts() {
        List<PostDto> postDtoList = postRepository.getAllPosts().stream().map(post -> ApiMapper.convertToPostDto(post)).collect(Collectors.toList());

        if (postDtoList.isEmpty()) throw new NoFoundException("No se encontraron posts");

        return postDtoList;
    }
}
