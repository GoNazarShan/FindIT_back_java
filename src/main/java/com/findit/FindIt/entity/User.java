package com.findit.FindIt.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private long id;

    @Column(name = "name")
    @JsonProperty("name")
    private String name;

    @Column(name = "surname")
    @JsonProperty("surname")
    private String surname;

    @Column(name = "patronymic_name")
    @JsonProperty("patronymicName")
    private String patronymicName;

    @Column(name = "email")
    @JsonProperty("email")
    private String email;

    @Column(name = "password")
    @JsonProperty("password")
    private String password;

    @Column(name = "level")
    @JsonProperty("level")
    private int level;
    
}
