package com.vitthal.document.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vitthal.document.entites.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {

}
