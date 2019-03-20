package com.devspods.domain;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "posts")
public class Post {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDateTime dateOfCreation;

    @NotNull
    private LocalDateTime dateOfLastUpdate;
    private LocalDateTime dateOfPublication;

    @Column(columnDefinition = "text", nullable = false)
    private String title;
	
    @Column(columnDefinition = "text", nullable = false)
    private String excerpt;
	
    @Column(columnDefinition = "longtext", nullable = false)
    private String content;
	
    @Valid
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id")
    private PostStatus status;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "posts_authors",
            joinColumns = { @JoinColumn(name = "post_id")},
            inverseJoinColumns = { @JoinColumn(name = "author_id")}
            )
    private Set<Author> authors;

    public Post() {

        this.dateOfCreation = LocalDateTime.now();
        this.dateOfLastUpdate = this.dateOfCreation;
    }

    public Long getId() {
        return this.id;
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public LocalDateTime getDateOfLastUpdate() {
        return this.dateOfLastUpdate;
    }

    public void setDateOfLastUpdate(LocalDateTime dateOfLastUpdate) {
        this.dateOfLastUpdate = dateOfLastUpdate;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExcerpt() {
        return this.excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public PostStatus getStatus() {
        return status;
    }

    public void setStatus(PostStatus status) {
        this.status = status;
    }

    public LocalDateTime getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(LocalDateTime dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}