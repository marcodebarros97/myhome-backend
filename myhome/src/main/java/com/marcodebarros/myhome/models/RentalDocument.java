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
    @Lob
    private byte[] document;

    public RentalDocument(String rentalDocumentName, String rentalDocumentDescription, byte[] document) {
        this.rentalDocumentName = rentalDocumentName;
        this.rentalDocumentDescription = rentalDocumentDescription;
        this.document = document;
    }
}
