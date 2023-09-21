package com.ict_project.ICT_PROJECT.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "documents")
@Entity
public class DocumentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "documentid" , nullable = false)
    private Long documentID;

    @Column(name = "document_name" , nullable = false)
    private String documentName;
}
