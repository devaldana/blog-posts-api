package com.devspods.domain;

import com.devspods.util.Sex;

import javax.persistence.*;
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

    @NotNull
    private LocalDateTime signUpDate;

    @Enumerated(EnumType.ORDINAL)
    @Column(columnDefinition = "tinyint", nullable = false)
    private Sex sex;

    public Author(){

        this.signUpDate = LocalDateTime.now();
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

    public LocalDateTime getSignUpDate() {
        return signUpDate;
    }

    public void setSignUpDate(LocalDateTime signUpDate) {
        this.signUpDate = signUpDate;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}
