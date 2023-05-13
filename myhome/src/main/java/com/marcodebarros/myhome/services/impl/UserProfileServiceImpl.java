package com.marcodebarros.myhome.services.impl;

import com.marcodebarros.myhome.models.UserPreference;
import com.marcodebarros.myhome.models.UserProfile;
import com.marcodebarros.myhome.repositories.UserProfileRepository;
import com.marcodebarros.myhome.services.UserProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileServiceImpl implements UserProfileService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private final UserProfileRepository userProfileRepository;

    public UserProfileServiceImpl(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public void createUser(UserProfile userToCreate) {
        userProfileRepository.save(userToCreate);
    }

    @Override
    public UserProfile getUserById(long userId) {
        Optional<UserProfile> user = userProfileRepository.findById(userId);
        if (user.isEmpty()) {
            logger.error("User with ID: {} not found", userId);
            return null;
        }
        return user.get();
    }

    @Override
    public UserProfile getUserByUsername(String username) {
        return userProfileRepository.findByUsername(username);
    }

    @Override
    public UserProfile updateUserPreference(Long userProfileId, UserPreference userPreference) {
        Optional<UserProfile> userProfileOptional = userProfileRepository.findById(userProfileId);
        if (userProfileOptional.isPresent()) {
            UserProfile userProfile = userProfileOptional.get();
            List<UserPreference> userPreferenceList = userProfile.getUserPreferences();
            userPreferenceList.add(userPreference);
            userProfile.setUserPreferences(userPreferenceList);
            userProfileRepository.save(userProfile);
            return userProfile;
        }
        return null;
    }
}
