package com.marcodebarros.myhome.serviceTests;

import com.marcodebarros.myhome.models.UserProfile;
import com.marcodebarros.myhome.repositories.UserProfileRepository;
import com.marcodebarros.myhome.services.impl.UserProfileServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.*;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    UserProfileRepository userProfileRepository;

    @InjectMocks
    UserProfileServiceImpl userProfileService;

    @Test
    public void testUserCreation() {
        UserProfile userProfile = new UserProfile("TestUser");
        userProfileService.createUser(userProfile);
        Mockito.verify(userProfileRepository, Mockito.times(1)).save(userProfile);
    }

    @Test
    public void testUserRetrievalByUserId() {
        UserProfile userProfile = new UserProfile("TestUser");
        Mockito.when(userProfileRepository.findById(Mockito.any())).thenReturn(Optional.of(userProfile));
        UserProfile userProfile1 = userProfileService.getUserById(1);
        Mockito.verify(userProfileRepository, Mockito.times(1)).findById(Mockito.any());
    }

    @Test
    public void testUserRetrievalByUsername() {
        UserProfile userProfile = new UserProfile("TestUser");
        Mockito.when(userProfileRepository.findByUsername(Mockito.any())).thenReturn(userProfile);
        UserProfile userProfile1 = userProfileService.getUserByUsername("TestUser");
        Mockito.verify(userProfileRepository, Mockito.times(1)).findByUsername(Mockito.any());
        assertThat(userProfile1.getUsername()).isEqualTo(userProfile.getUsername());
    }
}
