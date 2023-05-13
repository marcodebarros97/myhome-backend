package com.marcodebarros.myhome.serviceTests;

import com.marcodebarros.myhome.dto.UserPreferenceDto;
import com.marcodebarros.myhome.models.UserPreference;
import com.marcodebarros.myhome.models.UserProfile;
import com.marcodebarros.myhome.repositories.UserPreferenceRepository;
import com.marcodebarros.myhome.services.impl.UserPreferenceServiceImpl;
import com.marcodebarros.myhome.services.impl.UserProfileServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UserPreferenceServiceTest {
    @Mock
    UserProfileServiceImpl userProfileService;

    @Mock
    UserPreferenceRepository userPreferenceRepository;

    @InjectMocks
    UserPreferenceServiceImpl userPreferenceService;

    @Test
    public void testUserPreferenceCreation() {
        UserPreferenceDto userPreferenceDto = new UserPreferenceDto( 1234L,"Utrecht",
                new BigDecimal(0), new BigDecimal(1500), true, false);
        userPreferenceService.saveUserPreference(userPreferenceDto);
        Mockito.verify(userPreferenceRepository, Mockito.times(1)).save(any());
        Mockito.verify(userProfileService, Mockito.times(1)).updateUserPreference(any(), any());
    }

    @Test
    public void testGetUserPreferenceByUserProfile() {
        List<UserPreference> userPreferenceList = new ArrayList<>();
        UserPreference userPreference = new UserPreference("Utrecht",
                new BigDecimal(0), new BigDecimal(1500), true, false);
        userPreferenceList.add(userPreference);
        UserProfile userProfile = new UserProfile("TestUser");
        userProfile.setUserPreferences(userPreferenceList);
        userPreference.setUserProfile(userProfile);
        userPreferenceRepository.save(userPreference);

        userPreferenceService.getUserPreferenceByUserProfile(userProfile);

        Mockito.verify(userPreferenceRepository, Mockito.times(1)).findByUserProfile(any());
    }
}
