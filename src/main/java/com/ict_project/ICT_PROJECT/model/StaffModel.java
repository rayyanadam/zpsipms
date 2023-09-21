package com.ict_project.ICT_PROJECT.model;

import com.ict_project.ICT_PROJECT.enums.employmentGender;
import com.ict_project.ICT_PROJECT.enums.employmentMaritalStatus;
import com.ict_project.ICT_PROJECT.enums.employmentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "staff")
@Entity
public class StaffModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "staffid", nullable = false)
    private Long staffID;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "middle_name" , nullable = false)
    private String middleName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "email", nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    private employmentGender gender;

    @Column(name = "birth_date" , nullable = false)
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private employmentMaritalStatus maritalStatus;

    @Column(name = "nationality" , nullable = false)
    private String nationality;

    @Column(name = "date_hired" , nullable = false)
    private LocalDate dateHired;

    @Column(name = "department" , nullable = false)
    private String department;

    @Column(name = "employment_type" , nullable = false)
    private String employmentType;

    @Enumerated(EnumType.STRING)
    private employmentStatus status;

    @Column(name = "salary_scale" , nullable = false)
    private String salaryScale;

    @Column(name = "work_location" , nullable = false)
    private String workLocation;

    @OneToOne
    @JoinColumn(name = "userid")
    private UserModel userModel;
}
