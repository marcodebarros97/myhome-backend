package com.marcodebarros.myhome.controllers;

import com.marcodebarros.myhome.models.UserProfile;
import com.marcodebarros.myhome.services.UserProfileService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("userprofile/")
@AllArgsConstructor
public class UserProfileController {

    private UserProfileService userProfileService;

    @GetMapping("profile")
    public UserProfile getUserByUsername(@RequestParam String username){
        return userProfileService.getUserByUsername(username);
    }
}
