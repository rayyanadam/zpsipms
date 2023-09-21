package com.ict_project.ICT_PROJECT.repository;

import com.ict_project.ICT_PROJECT.model.StaffModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<StaffModel , Long> {
}
