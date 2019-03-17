package com.devspods.domain;

import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "posts")
public class Post {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    private LocalDateTime date = LocalDateTime.now();
    private LocalDateTime dateOfLastUpdate;
	
    @Column(columnDefinition = "text")
    private String title;
	
    @Column(columnDefinition = "text")
    private String excerpt;
	
    @Column(columnDefinition = "longtext")
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