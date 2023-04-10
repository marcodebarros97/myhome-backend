package com.marcodebarros.myhome;

import com.marcodebarros.myhome.models.UserProfile;
import com.marcodebarros.myhome.repositories.UserProfileRepository;
import com.marcodebarros.myhome.services.UserProfileService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserProfileTest {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private UserProfileService userProfileService;

    @Test
    public void testUserCreation(){
        List<UserProfile> users = userProfileRepository.findAll();
        Assertions.assertTrue(users.isEmpty());

        userProfileService.createUser(new UserProfile("testUsername"));

        UserProfile createdUser = userProfileService.getUserByUsername("testUsername");
        Assertions.assertNotNull(createdUser);
    }
}
