package com.bootcamp.be_java_hisp_w25_g14.service;

import com.bootcamp.be_java_hisp_w25_g14.dto.FollowedListResponseDto;
import com.bootcamp.be_java_hisp_w25_g14.dto.UserDataDto;
import com.bootcamp.be_java_hisp_w25_g14.entity.User;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.NotFoundException;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.NotSellerException;
import com.bootcamp.be_java_hisp_w25_g14.repository.IUserRepo;
import com.bootcamp.be_java_hisp_w25_g14.utils.ApiMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements  IUserService{

    private IUserRepo userRepo;

    public UserServiceImp(IUserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public FollowedListResponseDto listSellersFollowers(int id,String alphaOrder){
        Optional<User> userFollower = userRepo.findUserById(id);

        if (userFollower.isEmpty()) throw new NotFoundException("The user does not exists");

        if(!userFollower.get().getIsSeller()) throw new NotSellerException("the user is not a seller");

        return ApiMapper.listSellersFollowers(userFollower.get(),userRepo.listSellersFollowers(id,alphaOrder));
    }

    @Override
    public void addFollowe(Integer userId, Integer userIdToFollow) {
        this.userRepo.addFollower(userId,userIdToFollow);
    }

    @Override    public void removeFollow(Integer userId, Integer userIdToUnfollow) {
        this.userRepo.removeFollow(userId, userIdToUnfollow);
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
