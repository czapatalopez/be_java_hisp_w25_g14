package com.bootcamp.be_java_hisp_w25_g14.repository;

import com.bootcamp.be_java_hisp_w25_g14.dto.UserDto;
import com.bootcamp.be_java_hisp_w25_g14.dto.userDataDto;

import java.util.List;

public interface IUserRepo {
    void addFollower(Integer userId, Integer userIdToFollow);
    void removeFollow(Integer userID, Integer userIdToUnfollow);
    public List<userDataDto> getFollowed(Integer userId);

}
