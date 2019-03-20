package com.devspods.domain;

import javax.persistence.Entity;

@Entity
public class PostStatus extends Type {

    public PostStatus(){}

    public PostStatus(final String name){
        super(name);
    }

    public PostStatus(final String name, final String description){
        super(name, description);
    }
}