package com.bootcamp.be_java_hisp_w25_g14.service;

import com.bootcamp.be_java_hisp_w25_g14.dto.FollowedListResponseDto;

public interface IUserService {
    void addFollowe(Integer userId, Integer userIdToFollow);
    void removeFollow(Integer userId, Integer userIdToUnfollow);
    FollowedListResponseDto getFollowedByUser(Integer userId);
}
