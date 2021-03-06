package com.github.pedroluiznogueira.kardbankapi.domain.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String cpf;
    private String imagePath;

    public User(String name, String email, String cpf, String imagePath) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.imagePath = imagePath;
    }
}
