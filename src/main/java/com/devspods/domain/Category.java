package com.devspods.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category extends Type {

    public Category(){}

    public Category(final String name){
        super(name);
    }

    public Category(final String name, final String description){
        super(name, description);
    }
}
