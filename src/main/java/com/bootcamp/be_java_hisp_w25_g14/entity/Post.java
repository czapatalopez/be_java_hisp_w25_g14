package com.bootcamp.be_java_hisp_w25_g14.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Locale;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Post {
    Integer postId;
    Integer userId;
    Locale date;
    Product product;
    Integer category;
    Double price;
}
