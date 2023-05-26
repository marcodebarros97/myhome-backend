package com.marcodebarros.myhome.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "PROPERTY_SOURCE")
public class PropertySources {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long propertySourceId;
    private String URL;
    private String websiteName;
}
