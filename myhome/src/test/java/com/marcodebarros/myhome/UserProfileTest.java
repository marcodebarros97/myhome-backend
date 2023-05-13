package com.marcodebarros.myhome;

import com.marcodebarros.myhome.models.UserProfile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(value = {"integration-test"})
@EnableAutoConfiguration(exclude = { SecurityAutoConfiguration.class })
public class UserProfileTest {

    @Value(value = "${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void getUserByUsernameTest(){
        UserProfile userProfile = this.testRestTemplate
                .getForObject("http://localhost:" + port + "/userprofile/profile?username=TestUser",
                        UserProfile.class);
        assertThat(userProfile.getUserProfileId()).isNotNull();
    }
}
