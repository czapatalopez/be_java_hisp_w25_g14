package com.bootcamp.be_java_hisp_w25_g14.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    Integer postId;
    Integer userId;
    Product product;
    Integer category;
    Double price;
}
