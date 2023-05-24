package com.marcodebarros.myhome.repositories;

import com.marcodebarros.myhome.models.RentalDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalDocumentRepository extends JpaRepository<RentalDocument, Long> {
}
