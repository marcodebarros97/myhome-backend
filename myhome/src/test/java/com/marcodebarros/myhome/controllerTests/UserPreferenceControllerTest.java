package com.marcodebarros.myhome.controllerTests;

import com.marcodebarros.myhome.dto.UserPreferenceDto;
import com.marcodebarros.myhome.models.UserPreference;
import com.nimbusds.jose.shaded.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@ActiveProfiles(value = {"integration-test"})
@EnableAutoConfiguration(exclude = { SecurityAutoConfiguration.class })
public class UserPreferenceControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void testPreferenceCreation(){
        UserPreferenceDto userPreferenceDto = new UserPreferenceDto(1234L ,"Utrecht",
                new BigDecimal(0), new BigDecimal(1500), true, false);
        try {
            Gson gson = new Gson();
            String json = gson.toJson(userPreferenceDto);
            mockMvc.perform(post("/userpreferences/savepreference").contentType(MediaType.APPLICATION_JSON)
                    .content(json)).andExpect(status().isOk());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
