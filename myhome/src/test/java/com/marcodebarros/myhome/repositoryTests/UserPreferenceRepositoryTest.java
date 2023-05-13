package com.marcodebarros.myhome.repositoryTests;

import com.marcodebarros.myhome.models.UserPreference;
import com.marcodebarros.myhome.models.UserProfile;
import com.marcodebarros.myhome.repositories.UserPreferenceRepository;
import com.marcodebarros.myhome.repositories.UserProfileRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@DataJpaTest
public class UserPreferenceRepositoryTest {
    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UserPreferenceRepository userPreferenceRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @BeforeEach
    public void clearDatabase(){
        userProfileRepository.deleteAll();
        userPreferenceRepository.deleteAll();
    }
    @Test
    public void createUserPreference(){
        UserPreference userPreference = new UserPreference("Utrecht", new BigDecimal(0),
                new BigDecimal(1500), true, false);
        userPreferenceRepository.save(userPreference);
        assertThat(userPreferenceRepository.findAll()).isNotEmpty();
    }

    @Test
    public void findUserPreferenceByUser(){
        UserProfile userProfile = new UserProfile("TestUser");
        userProfileRepository.save(userProfile);
        assertThat(userProfileRepository.findAll()).isNotEmpty();

        UserPreference userPreference = new UserPreference("Utrecht", new BigDecimal(0),
                new BigDecimal(1500), true, false);
        List<UserPreference> userPreferenceList = new ArrayList<>();
        userPreferenceList.add(userPreference);
        userProfile.setUserPreferences(userPreferenceList);
        userPreferenceRepository.save(userPreference);
        userProfileRepository.save(userProfile);

        assertThat(userProfileRepository.findAll()).isNotEmpty();
        assertThat(userPreferenceRepository.findAll()).isNotEmpty();

        List<UserPreference> userPreferenceListToTest = userPreferenceRepository.findByUserProfile(userProfile);
        userPreferenceListToTest.forEach(userPreference1 -> {
            assertThat(userPreference1.getCity()).isEqualTo("Utrecht");
        });
    }
}
