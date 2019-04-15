package com.devspods.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Gender extends Type {

    @JsonIgnore
    @OneToMany( fetch = FetchType.LAZY, mappedBy = "gender")
    private Set<Author> authors = new HashSet<>();

    public Gender(){}

    public Gender(String name){
        super(name);
    }

    public Gender(String name, String description){
        super(name, description);
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}
