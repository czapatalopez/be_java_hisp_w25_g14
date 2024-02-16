package com.bootcamp.be_java_hisp_w25_g14.repository;

public interface IUserRepo {
    void addFollower(Integer userId, Integer userIdToFollow);

}
