package com.bootcamp.be_java_hisp_w25_g14.repository;

import com.bootcamp.be_java_hisp_w25_g14.entity.User;

import java.util.Optional;

public interface IUserRepo {
    void addFollower(Integer userId, Integer userIdToFollow);
    Optional<User> findUserById(Integer id);

}
