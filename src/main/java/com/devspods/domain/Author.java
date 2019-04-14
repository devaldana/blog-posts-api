package com.devspods.domain;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 32)
    private String name;

    @NotBlank
    @Column(nullable = false, length = 32)
    private String lastName;

    @Column(columnDefinition = "text")
    private String avatarPath;

    @Column(columnDefinition = "text")
    private String description;

    @NotNull
    private LocalDateTime dateOfSingUp;

    @Valid
    @NotNull
    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;

    public Author(){

        this.dateOfSingUp = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDateTime getDateOfSingUp() {
        return dateOfSingUp;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateOfSingUp(LocalDateTime dateOfSingUp) {
        this.dateOfSingUp = dateOfSingUp;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
