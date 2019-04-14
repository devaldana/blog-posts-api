package com.devspods.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category extends Type {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private Set<Post> posts = new HashSet<>();

    public Category(){}

    public Category(final String name){
        super(name);
    }

    public Category(final String name, final String description){
        super(name, description);
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }
}
