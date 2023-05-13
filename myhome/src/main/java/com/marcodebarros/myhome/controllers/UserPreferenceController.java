package com.marcodebarros.myhome.controllers;

import com.marcodebarros.myhome.dto.UserPreferenceDto;
import com.marcodebarros.myhome.models.UserPreference;
import com.marcodebarros.myhome.services.UserPreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userpreferences")
public class UserPreferenceController {

    @Autowired
    private UserPreferenceService userPreferenceService;
    @PostMapping("/savepreference")
    public ResponseEntity<String> createUserPreference(@RequestBody UserPreferenceDto userPreferenceDto){
        userPreferenceService.saveUserPreference(userPreferenceDto);
        return new ResponseEntity<>("Preference saved", HttpStatus.OK);
    }
}
