package com.bootcamp.be_java_hisp_w25_g14.service;

import com.bootcamp.be_java_hisp_w25_g14.dto.UserFollowersCountDto;

public interface IUserService {
    void addFollowe(Integer userId, Integer userIdToFollow);
    void removeFollow(Integer userId, Integer userIdToUnfollow);

    UserFollowersCountDto getUserFollowersCount(Integer userId);
}
