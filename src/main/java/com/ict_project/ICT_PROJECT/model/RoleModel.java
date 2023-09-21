package com.ict_project.ICT_PROJECT.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "role")
@Entity
public class RoleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "roleid" , nullable = false)
    private Long userID;

    @Column(name = "role_name", nullable = false)
    private String roleName;
}
