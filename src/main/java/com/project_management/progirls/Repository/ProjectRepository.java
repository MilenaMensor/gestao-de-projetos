package com.project_management.progirls.Repository;

import com.project_management.progirls.Models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
