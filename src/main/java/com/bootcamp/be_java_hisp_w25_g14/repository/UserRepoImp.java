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

        validateIfUserExists(follower,"Unable to find user");
        validateIfUserExists(follower,"Unable to find user to follow");
        validateIsSeller(toFollow.get());
        if(follower.get().getFollowed().contains(userIdToFollow) || toFollow.get().getFollowers().contains(userId))
            throw new FollowException("Already follow");

        follower.get().getFollowed().add(userIdToFollow);
        toFollow.get().getFollowers().add(userId);

    }

    @Override
    public void removeFollow(Integer userId, Integer userIdToUnfollow) {
        Optional<User> follower = this.userList.stream().filter(user -> user.getUserId().equals(userId)).findFirst();
        Optional<User> toFollow = this.userList.stream().filter(user -> user.getUserId().equals(userIdToUnfollow)).findFirst();

        validateIfUserExists(follower,"Unable to find user");
        validateIfUserExists(follower,"Unable to find user to follow");

        if(!follower.get().getFollowed().contains(userIdToUnfollow) || !toFollow.get().getFollowers().contains(userId))
            throw new FollowException("Can't unfollow, You don't follow this user");

        follower.get().getFollowed().remove(userIdToUnfollow);
        toFollow.get().getFollowers().remove(userId);
    }

    private void validateIfUserExists(Optional<User> user, String message){
        if (user.isEmpty()){
            throw  new NoFoundException(message);
        }
    }

    private void validateIsSeller(User user){
        if (!user.getSeller())
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
