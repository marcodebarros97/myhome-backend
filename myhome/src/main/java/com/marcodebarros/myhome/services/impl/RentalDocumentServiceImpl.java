package com.marcodebarros.myhome.services.impl;

import com.marcodebarros.myhome.dto.RentalDocumentDto;
import com.marcodebarros.myhome.models.RentalDocument;
import com.marcodebarros.myhome.repositories.RentalDocumentRepository;
import com.marcodebarros.myhome.services.RentalDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RentalDocumentServiceImpl implements RentalDocumentService {

    private final RentalDocumentRepository rentalDocumentRepository;

    @Autowired
    public RentalDocumentServiceImpl(RentalDocumentRepository rentalDocumentRepository) {
        this.rentalDocumentRepository = rentalDocumentRepository;
    }

    @Override
    public RentalDocument findRentalDocument(Long documentId) {
        Optional<RentalDocument> rentalDocument = rentalDocumentRepository.findById(documentId);
        return rentalDocument.orElse(null);
    }

    @Override
    public RentalDocument saveDocument(RentalDocumentDto rentalDocumentDto) {
        RentalDocument rentalDocument = new RentalDocument(rentalDocumentDto.getRentalDocumentName(),
                rentalDocumentDto.getRentalDocumentDescription(), rentalDocumentDto.getFile());
        rentalDocument = rentalDocumentRepository.save(rentalDocument);
        return rentalDocument;
    }
}
