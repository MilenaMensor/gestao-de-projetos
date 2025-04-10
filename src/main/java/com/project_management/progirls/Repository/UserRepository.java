package com.project_management.progirls.Repository;

import com.project_management.progirls.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
