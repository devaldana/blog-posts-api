package com.devspods.domain;

import javax.persistence.*;

@Entity
@Table(name = "post_details")
public class PostDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "longtext", nullable = false)
    private String content;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    private Post post;

    public PostDetail() {}

    public PostDetail(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
