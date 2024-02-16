package com.bootcamp.be_java_hisp_w25_g14.service;

import com.bootcamp.be_java_hisp_w25_g14.repository.IUserRepo;
import com.bootcamp.be_java_hisp_w25_g14.repository.UserRepoImp;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements  IUserService{

    private IUserRepo userRepo;

    public UserServiceImp(IUserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void addFollowe(Integer userId, Integer userIdToFollow) {
        this.userRepo.addFollower(userId,userIdToFollow);
    }
}
