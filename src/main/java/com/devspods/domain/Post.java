package com.devspods.domain;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
public class Post {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDateTime date = LocalDateTime.now();
    private LocalDateTime dateOfLastUpdate;
	
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
	
    public Long getId() {
        return this.id;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
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
}