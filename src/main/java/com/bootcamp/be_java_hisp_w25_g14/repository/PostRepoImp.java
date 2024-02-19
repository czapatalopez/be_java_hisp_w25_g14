package com.bootcamp.be_java_hisp_w25_g14.repository;

import com.bootcamp.be_java_hisp_w25_g14.entity.Post;
import com.bootcamp.be_java_hisp_w25_g14.entity.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
@Repository
public class PostRepoImp implements IPostRepo{

    List<Post> postList;

    public PostRepoImp(List<Product> postList) {
        this.postList = new ArrayList<>();
        loadPosts();
    }

    @Override
    public void savePost(Post post) {
        this.postList.add(post);
    }

    @Override
    public List<Post> getAllPosts() {
        return postList;
    }


    private void loadPosts()  {
        try{
            ObjectMapper mapper = new ObjectMapper();
            File jsonFile=null;
            jsonFile = ResourceUtils.getFile("classpath:post.json");
            this.postList = mapper.readValue(jsonFile, new TypeReference<List<Post>>() {
                @Override
                public Type getType() {
                    return super.getType();
                }
            });
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


}
