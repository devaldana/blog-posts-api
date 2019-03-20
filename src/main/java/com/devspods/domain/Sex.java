package com.devspods.domain;

import javax.persistence.Entity;

@Entity
public class Sex extends Type {

    public Sex(){}

    public Sex(final String name){
        super(name);
    }

    public Sex(final String name, final String description){
        super(name, description);
    }
}
