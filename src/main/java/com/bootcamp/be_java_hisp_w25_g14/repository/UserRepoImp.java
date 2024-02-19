package com.bootcamp.be_java_hisp_w25_g14.repository;

import com.bootcamp.be_java_hisp_w25_g14.entity.User;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.NoFoundException;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.FollowException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepoImp implements IUserRepo {

    List<User> userList;

    public UserRepoImp() {
        this.userList = new ArrayList<>();
        loadUsers();
    }


    @Override
    public void addFollower(Integer userId, Integer userIdToFollow) {
        if (userId.equals(userIdToFollow))
            throw new FollowException("Unable to follow itself");

        Optional<User> follower = this.userList.stream().filter(user -> user.getUserId().equals(userId)).findFirst();
        Optional<User> toFollow = this.userList.stream().filter(user -> user.getUserId().equals(userIdToFollow)).findFirst();

        if (follower.isEmpty())
            throw  new NoFoundException("Unable to find user");
        if (toFollow.isEmpty())
            throw  new NoFoundException("Unable to find user to follow");

        if(follower.get().getFollowed().contains(userIdToFollow) || toFollow.get().getFollowers().contains(userId))
            throw new FollowException("Already follow");
        validateIsSeller(toFollow.get());

        System.out.println("follower = " + follower.get());
        System.out.println("followed = " + toFollow.get());

        follower.get().getFollowed().add(userIdToFollow);
        toFollow.get().getFollowers().add(userId);
        System.out.println("follower = " + follower.get());
        System.out.println("followed = " + toFollow.get());
    }

    @Override
    public Optional<User> findUserById(Integer id) {
        return this.userList.stream().filter(user -> user.getUserId().equals(id)).findFirst();
    }

    private void validateIsSeller(User user){
        if (!user.getIsSeller())
            throw  new FollowException("The user to follow isn't seller");
    }

    private void loadUsers()  {
        try{
            ObjectMapper mapper = new ObjectMapper();

            File jsonFile=null;
            jsonFile = ResourceUtils.getFile("classpath:user.json");
            this.userList = mapper.readValue(jsonFile, new TypeReference<List<User>>() {
                @Override
                public Type getType() {
                    return super.getType();
                }
            });
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
