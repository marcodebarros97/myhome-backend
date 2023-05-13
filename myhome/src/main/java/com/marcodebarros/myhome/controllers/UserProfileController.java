package com.marcodebarros.myhome.controllers;

import com.marcodebarros.myhome.models.UserProfile;
import com.marcodebarros.myhome.services.UserProfileService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.security.Principal;

@RestController
@RequestMapping("userprofile/")
@AllArgsConstructor
public class UserProfileController {

    private UserProfileService userProfileService;

    @GetMapping("profile")
    public UserProfile getUserByUsername(@RequestParam String username){
        return userProfileService.getUserByUsername(username);
    }

    @PostMapping("register")
    public ResponseEntity<UserProfile> registerNewUser(JwtAuthenticationToken principal){
        UserProfile userProfile = new UserProfile(principal.getName());
        userProfileService.createUser(userProfile);
        return new ResponseEntity<>(userProfile, HttpStatus.OK);
    }
}
