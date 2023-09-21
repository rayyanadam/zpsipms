package com.ict_project.ICT_PROJECT.repository;

import com.ict_project.ICT_PROJECT.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel , Long> {
}
