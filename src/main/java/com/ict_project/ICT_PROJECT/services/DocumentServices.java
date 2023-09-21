package com.ict_project.ICT_PROJECT.services;


import com.ict_project.ICT_PROJECT.model.DocumentModel;
import com.ict_project.ICT_PROJECT.repository.DocumentRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Builder
public class DocumentServices {
    private final DocumentRepository documentRepository;

    public DocumentModel saveDocument(DocumentModel document) {
        return documentRepository.save(document);
    }

    public List<DocumentModel> getAllDocument() {
        return documentRepository.findAll();
    }

    public Optional<DocumentModel> getDocumentById(Long id) {
        return documentRepository.findById(id);
    }

    public DocumentModel updateDocument(Long id, DocumentModel documentModel) {
        Optional<DocumentModel> optionalDocument = documentRepository.findById(id);
        if (optionalDocument.isPresent()) {
            DocumentModel existingDocument = optionalDocument.get();
            existingDocument.setDocumentName(documentModel.getDocumentName());
            return documentRepository.save(existingDocument);
        } else {
            return null;
        }
    }

    public DocumentModel deleteDocument(Long id) {
        Optional<DocumentModel> documentToDelete = documentRepository.findById(id);
        if (documentToDelete.isPresent()) {
            documentRepository.deleteById(id);
            return documentToDelete.get();
        } else {
            return null;
        }
    }
}
