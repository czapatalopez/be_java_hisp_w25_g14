package com.bootcamp.be_java_hisp_w25_g14.service;

import com.bootcamp.be_java_hisp_w25_g14.dto.UserFollowersCountDto;
import com.bootcamp.be_java_hisp_w25_g14.entity.User;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.FollowException;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.NotFoundException;
import com.bootcamp.be_java_hisp_w25_g14.dto.FollowedListResponseDto;
import com.bootcamp.be_java_hisp_w25_g14.dto.UserDataDto;
import com.bootcamp.be_java_hisp_w25_g14.entity.User;
import com.bootcamp.be_java_hisp_w25_g14.repository.IUserRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;


import java.util.List;

@Service
public class UserServiceImp implements IUserService {

    private IUserRepo userRepo;

    public UserServiceImp(IUserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void addFollowe(Integer userId, Integer userIdToFollow) {
        this.userRepo.addFollower(userId, userIdToFollow);
    }

    @Override    public void removeFollow(Integer userId, Integer userIdToUnfollow) {
        this.userRepo.removeFollow(userId, userIdToUnfollow);
    }

    @Override
    public UserFollowersCountDto getUserFollowersCount(Integer userId) {
        Optional<User> optionalUser = userRepo.findUserById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (!user.getIsSeller())
                throw new FollowException("The user is not a seller");
            int followersCount = user.getFollowers().size();
            return new UserFollowersCountDto(userId, user.getUserName(), followersCount);
        } else {
            throw new NotFoundException("User not found");
        }

    }



    @Override
    public FollowedListResponseDto getFollowedByUser(Integer userId){
        List<UserDataDto> userFollowed = this.userRepo.getFollowed(userId);
        Optional<User> user = this.userRepo.findUserById(userId);
        return user.map(value -> new FollowedListResponseDto(
                value.getUserId(),
                value.getUserName(),
                userFollowed
        )).orElse(null);
    }
}
