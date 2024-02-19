package com.bootcamp.be_java_hisp_w25_g14.utils;

import com.bootcamp.be_java_hisp_w25_g14.entity.Post;

import java.util.Comparator;
import java.util.List;

public class HelperFunctions {
    public static List<Post> sortPostsByDateAscending(List<Post> list){
        list.sort(Comparator.comparing(Post::getDate));
        return list;
    }

    public static List<Post> sortPostsByDateDescending(List<Post> list){
        list.sort(Comparator.comparing(Post::getDate, Comparator.reverseOrder()));
        return list;
    }
}
