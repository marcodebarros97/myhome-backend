package com.marcodebarros.myhome.services.impl;

import com.marcodebarros.myhome.dto.UserPreferenceDto;
import com.marcodebarros.myhome.models.UserPreference;
import com.marcodebarros.myhome.models.UserProfile;
import com.marcodebarros.myhome.repositories.UserPreferenceRepository;
import com.marcodebarros.myhome.services.UserPreferenceService;
import com.marcodebarros.myhome.services.UserProfileService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserPreferenceServiceImpl implements UserPreferenceService {

    private final UserPreferenceRepository userPreferenceRepository;
    private final UserProfileService userProfileService;

    public UserPreferenceServiceImpl(UserPreferenceRepository userPreferenceRepository, UserProfileService userProfileService) {
        this.userPreferenceRepository = userPreferenceRepository;
        this.userProfileService = userProfileService;
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void saveUserPreference(UserPreferenceDto userPreferenceDto) {
        if (userPreferenceDto != null) {
            UserPreference userPreference = new UserPreference(userPreferenceDto.getCity(),
                    userPreferenceDto.getMinimumAmount(), userPreferenceDto.getMaximumAmount(),
                    userPreferenceDto.getPreferRent(), userPreferenceDto.getPreferFurnished());
            userProfileService.updateUserPreference(userPreferenceDto.getUserProfileId(), userPreference);
            userPreferenceRepository.save(userPreference);
        }
    }

    @Override
    public List<UserPreference> getUserPreferenceByUserProfile(UserProfile userProfile) {
        return userPreferenceRepository.findByUserProfile(userProfile);
    }

}
