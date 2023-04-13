package com.marcodebarros.myhome.repositoryTests;

import com.marcodebarros.myhome.models.UserProfile;
import com.marcodebarros.myhome.repositories.UserProfileRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;

import java.util.Optional;

@DataJpaTest
public class UserProfileRepositoryTest {
    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Test
    public void testUserProfileRetrievalById() {
        Optional<UserProfile> userProfile = userProfileRepository.findById(1L);
        assertThat(userProfile.isPresent()).isTrue();
        assertThat(userProfile.get().getUsername()).isEqualTo("TestUser");
    }

    @Test
    public void testUserProfileRetrievalByUsername() {
        UserProfile userProfile = userProfileRepository.findByUsername("TestUser");
        assertThat(userProfile.getUserId()).isEqualTo(1L);
    }
}
