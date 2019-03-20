package com.devspods.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

@MappedSuperclass
public abstract class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 4, max = 128)
    @Column(nullable = false, unique = true)
    private String name;

    @Column(columnDefinition = "text")
    private String description;

    public Type() {}

    public Type(final String name) {
        this.name = name;
    }

    public Type(final String name, final String description) {
        this(name);
        this.description = description;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
