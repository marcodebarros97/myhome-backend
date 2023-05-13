package com.marcodebarros.myhome.services;


import com.marcodebarros.myhome.dto.UserPreferenceDto;
import com.marcodebarros.myhome.models.UserPreference;
import com.marcodebarros.myhome.models.UserProfile;

import java.util.List;

public interface UserPreferenceService {
    void saveUserPreference(UserPreferenceDto userPreferenceDto);
    List<UserPreference> getUserPreferenceByUserProfile(UserProfile userProfile);
}
