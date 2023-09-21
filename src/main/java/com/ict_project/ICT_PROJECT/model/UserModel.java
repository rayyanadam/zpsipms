package com.ict_project.ICT_PROJECT.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "all_user")
@Entity
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid", nullable = false)
    private Long userID;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "position", nullable = false)
    private String position;

    @Column(name = "password", nullable = false)
    private String password;
}
