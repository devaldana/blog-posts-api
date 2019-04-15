package com.devspods.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class PostStatus extends Type {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "status")
    private Set<Post> posts = new HashSet<>();

    public PostStatus() {}

    public PostStatus(String name) {
        super(name);
    }

    public PostStatus(String name, String description) {
        super(name, description);
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }
}