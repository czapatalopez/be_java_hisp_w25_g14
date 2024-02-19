package com.bootcamp.be_java_hisp_w25_g14.utils;

import com.bootcamp.be_java_hisp_w25_g14.dto.PostDto;
import com.bootcamp.be_java_hisp_w25_g14.dto.ProductDto;
import com.bootcamp.be_java_hisp_w25_g14.entity.Post;
import com.bootcamp.be_java_hisp_w25_g14.entity.Product;

public class ApiMapper {


    public static PostDto convertToPostDto(Post post){

        PostDto postDto = new PostDto();

        postDto.setPost_id(post.getPostId());
        postDto.setUser_id(post.getUserId());
        postDto.setDate(post.getDate());
        postDto.setProduct(convertToProductDto(post.getProduct()));
        postDto.setCategory(post.getCategory());
        postDto.setPrice(post.getPrice());

        return postDto;

    }

    public static Post convertToPostEntity(PostDto postDto){

        Post post = new Post();

        post.setPostId(postDto.getPost_id());
        post.setUserId(postDto.getUser_id());
        post.setDate(postDto.getDate());
        post.setProduct(convertToProductEntity(postDto.getProduct()));
        post.setCategory(postDto.getCategory());
        post.setPrice(postDto.getPrice());

        return post;

    }


    public static ProductDto convertToProductDto(Product product){
        ProductDto productDto = new ProductDto();

        productDto.setProduct_id(product.getProductId());
        productDto.setProduct_name(product.getProductName());
        productDto.setType(product.getType());
        productDto.setBrand(product.getBrand());
        productDto.setColor(product.getColor());
        productDto.setNotes(product.getNotes());

        return productDto;

    }
    public static Product convertToProductEntity(ProductDto productDto){
        Product product = new Product();

        product.setProductId(productDto.getProduct_id());
        product.setProductName(productDto.getProduct_name());
        product.setType(productDto.getType());
        product.setBrand(productDto.getBrand());
        product.setColor(productDto.getColor());
        product.setNotes(productDto.getNotes());

        return product;

    }



}
