package com.marcodebarros.myhome.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "USER_PREFERENCE")
public class UserPreference {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userPreferenceId;

    private String city;

    private BigDecimal minimumAmount;

    private BigDecimal maximumAmount;

    private Boolean preferRent;

    private Boolean preferFurnished;

    @ManyToOne
    @JoinColumn(name = "user_profile_id")
    private UserProfile userProfile;

    public UserPreference(String city, BigDecimal minimumAmount, BigDecimal maximumAmount, Boolean preferRent, Boolean preferFurnished) {
        this.city = city;
        this.minimumAmount = minimumAmount;
        this.maximumAmount = maximumAmount;
        this.preferRent = preferRent;
        this.preferFurnished = preferFurnished;
    }
}
