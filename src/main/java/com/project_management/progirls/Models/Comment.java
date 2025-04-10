package com.project_management.progirls.Models;

import jakarta.persistence.*;
import lombok.Cleanup;
import lombok.Data;

@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Tasks tasks;
}
