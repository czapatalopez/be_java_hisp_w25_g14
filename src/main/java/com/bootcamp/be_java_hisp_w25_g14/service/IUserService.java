package com.bootcamp.be_java_hisp_w25_g14.service;

public interface IUserService {
    void addFollowe(Integer userId, Integer userIdToFollow);
    void removeFollow(Integer userId, Integer userIdToUnfollow);
}
