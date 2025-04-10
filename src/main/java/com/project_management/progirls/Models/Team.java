package com.project_management.progirls.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String teamName;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<User> members;
}
