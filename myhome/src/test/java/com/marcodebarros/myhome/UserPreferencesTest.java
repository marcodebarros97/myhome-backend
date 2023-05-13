package com.marcodebarros.myhome;

import com.marcodebarros.myhome.dto.UserPreferenceDto;
import com.marcodebarros.myhome.models.UserPreference;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(value = {"integration-test"})
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
public class UserPreferencesTest {
    @Value(value = "${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testSaveUserPreference() {
        UserPreferenceDto userPreferenceDto = new UserPreferenceDto(1234L ,"Utrecht",
                new BigDecimal(0), new BigDecimal(1500), true, false);

        ResponseEntity<String> responseEntity = testRestTemplate.postForEntity("http://localhost:" + port +
                "/userpreferences/savepreference", userPreferenceDto, String.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
