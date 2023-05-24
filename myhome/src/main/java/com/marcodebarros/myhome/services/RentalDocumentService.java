package com.marcodebarros.myhome.services;

import com.marcodebarros.myhome.dto.RentalDocumentDto;
import com.marcodebarros.myhome.models.RentalDocument;

public interface RentalDocumentService {
    RentalDocument findRentalDocument(Long documentId);

    RentalDocument saveDocument(RentalDocumentDto rentalDocumentDto);
}
