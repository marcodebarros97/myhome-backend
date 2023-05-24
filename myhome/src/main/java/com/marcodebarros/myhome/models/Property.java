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
@Table(name = "PROPERTY")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long propertyId;

    private String propertyName;
    private String propertyAddress;
    private BigDecimal propertyPrice;
    private int propertySize;
    private int numberOfRooms;
    private int delivery;

    public Property(String propertyName, String propertyAddress, BigDecimal propertyPrice, int propertySize, int numberOfRooms, int delivery) {
        this.propertyName = propertyName;
        this.propertyAddress = propertyAddress;
        this.propertyPrice = propertyPrice;
        this.propertySize = propertySize;
        this.numberOfRooms = numberOfRooms;
        this.delivery = delivery;
    }
}
