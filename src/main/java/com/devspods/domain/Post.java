package com.devspods.domain;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
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

    @NotEmpty
    @Column(columnDefinition = "text", nullable = false)
    private String permalink;

    @NotEmpty
    @Column(columnDefinition = "text", nullable = false)
    private String title;

    @NotEmpty
    @Column(columnDefinition = "text", nullable = false)
    private String excerpt;

    @Valid
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Valid
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    private PostStatus status;

    @Valid
    @NotNull
    @OneToOne(mappedBy = "post", cascade = CascadeType.ALL)
    private PostDetail postDetail;

    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "posts_authors",
            joinColumns = { @JoinColumn(name = "post_id")},
            inverseJoinColumns = { @JoinColumn(name = "author_id")}
            )
    private Set<Author> authors = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "posts_technical_reviewers",
            joinColumns = { @JoinColumn(name = "post_id")},
            inverseJoinColumns = { @JoinColumn(name = "author_id")}
    )
    private Set<Author> technicalReviewers = new HashSet<>();

    public Post() {
        this.dateOfCreation = LocalDateTime.now();
        this.dateOfLastUpdate = this.dateOfCreation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public LocalDateTime getDateOfLastUpdate() {
        return dateOfLastUpdate;
    }

    public void setDateOfLastUpdate(LocalDateTime dateOfLastUpdate) {
        this.dateOfLastUpdate = dateOfLastUpdate;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public Category getCategory() {
        return category;
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

    public Set<Author> getTechnicalReviewers() {
        return technicalReviewers;
    }

    public void setTechnicalReviewers(Set<Author> technicalReviewers) {
        this.technicalReviewers = technicalReviewers;
    }

    public void addAuthor(Author author){
        authors.add(author);
    }

    public  void addTechnicalReviewer(Author author){
        technicalReviewers.add(author);
    }

    public PostDetail getPostDetail() {
        return postDetail;
    }

    public void setPostDetail(PostDetail postDetail) {
        postDetail.setPost(this);
        this.postDetail = postDetail;
    }

    public void setContent(String content){
        if(postDetail == null) setPostDetail(new PostDetail(content));
        else postDetail.setContent(content);
    }

    public Optional<String> getContent(){
        if(postDetail != null) return Optional.ofNullable(getPostDetail().getContent());
        return Optional.empty();
    }
}