package com.marcodebarros.myhome.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "USER_PROFILE")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userProfileId;

    private String username;

    @OneToMany(mappedBy = "userProfile")
    private List<UserPreference> userPreferences;

    public UserProfile(String username) {
        this.username = username;
    }
}
