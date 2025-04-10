package com.project_management.progirls.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project projects;

    @OneToMany(mappedBy = "tasks", cascade = CascadeType.ALL)
    private List<Comment> comments;
}
