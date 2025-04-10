package com.project_management.progirls.Controller;

import com.project_management.progirls.Models.Project;
import com.project_management.progirls.Service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    // Rota GET para listar todos os projetos
    @GetMapping
    public ResponseEntity<List<Project>> getProjects() {
        return ResponseEntity.status(200).body(projectService.projectList());
    }

    // Rota POST para adicionar novos projetos à lista
    @PostMapping
    public ResponseEntity<Project> newProject(@RequestBody @Valid Project project) {
        return ResponseEntity.status(200).body(projectService.newProject(project));
    }

    // Rota DELETE para excluir um projeto pelo seu ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable Long id) {
        projectService.projectDelete(id);
        return ResponseEntity.status(204).build();
    }
}
