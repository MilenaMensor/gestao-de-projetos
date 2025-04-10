package com.project_management.progirls.Service;

import com.project_management.progirls.Models.Project;
import com.project_management.progirls.Repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    // Lista os projetos
    public List<Project> projectList() {
        return projectRepository.findAll();
    }

    // Adicionar um projeto novo
    public Project newProject(Project project) {
        return projectRepository.save(project);
    }

    // Deletar um projeto pelo seu ID
    public boolean projectDelete(Long id) {
        projectRepository.deleteById(id);
        return true;
    }
}
