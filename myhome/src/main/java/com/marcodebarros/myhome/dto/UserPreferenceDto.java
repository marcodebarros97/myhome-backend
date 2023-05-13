package com.marcodebarros.myhome.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserPreferenceDto {
    private Long userProfileId;
    private String city;
    private BigDecimal minimumAmount;
    private BigDecimal maximumAmount;
    private Boolean preferRent;
    private Boolean preferFurnished;
}
