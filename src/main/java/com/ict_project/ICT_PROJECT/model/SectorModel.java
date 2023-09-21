package com.ict_project.ICT_PROJECT.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sector")
@Entity
public class SectorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sectorid" , nullable = false)
    private Long sectorID;

    @Column(name = "sector_name" , nullable = false)
    private String sectorName;

    @Column(name = "sector_address" , nullable = false)
    private String sectorAddress;
}
