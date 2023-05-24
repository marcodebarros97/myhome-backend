package com.marcodebarros.myhome.dto;

import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RentalDocumentDto {
    private String rentalDocumentName;
    private String rentalDocumentDescription;
    private byte[] file;
}
