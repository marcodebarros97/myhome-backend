package com.marcodebarros.myhome.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "RENTAL_DOCUMENTS")
public class RentalDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rentalDocumentId;
    private String rentalDocumentName;
    private String rentalDocumentDescription;
    private Lob file;

    public RentalDocument(String rentalDocumentName, String rentalDocumentDescription, Lob file) {
        this.rentalDocumentName = rentalDocumentName;
        this.rentalDocumentDescription = rentalDocumentDescription;
        this.file = file;
    }
}
