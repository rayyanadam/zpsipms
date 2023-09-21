package com.ict_project.ICT_PROJECT.repository;

import com.ict_project.ICT_PROJECT.model.DocumentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<DocumentModel , Long> {
}
