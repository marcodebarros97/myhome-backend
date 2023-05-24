package com.marcodebarros.myhome.controllers;

import com.marcodebarros.myhome.dto.RentalDocumentDto;
import com.marcodebarros.myhome.models.RentalDocument;
import com.marcodebarros.myhome.services.RentalDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rental-documents")
public class RentalDocumentController {

    @Autowired
    private RentalDocumentService rentalDocumentService;

    @GetMapping("/document")
    public ResponseEntity<RentalDocument> getDocument(@RequestParam Long documentId) {
        RentalDocument rentalDocument = rentalDocumentService.findRentalDocument(documentId);
        if (rentalDocument != null) {
            return new ResponseEntity<>(rentalDocument, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<String> uploadDocument(@RequestBody RentalDocumentDto rentalDocumentDto) {
        RentalDocument rentalDocument = rentalDocumentService.saveDocument(rentalDocumentDto);
        return new ResponseEntity<>("File " + rentalDocument.getRentalDocumentName() + " uploaded",
                HttpStatus.OK);
    }
}
