package com.marcodebarros.myhome.services;

import com.marcodebarros.myhome.models.UserProfile;

public interface UserProfileService {
    void createUser(UserProfile userToCreate);

    UserProfile getUserById(long userId);

    UserProfile getUserByUsername(String username);
}
