package com.devspods.projections;

import java.time.LocalDateTime;

public class PostBasicInfo {

    private Long id;
    private String title;
    private LocalDateTime dateOfPublication;
    private LocalDateTime dateOfLastUpdate;
    private String excerpt;
    private String category;
    private String status;

    /* Authors and Reviewers information pending */

    public PostBasicInfo(){}

    public PostBasicInfo(Long id, String title, LocalDateTime dateOfPublication, LocalDateTime dateOfLastUpdate, String excerpt, String category, String status) {
        this.id = id;
        this.title = title;
        this.dateOfPublication = dateOfPublication;
        this.dateOfLastUpdate = dateOfLastUpdate;
        this.excerpt = excerpt;
        this.category = category;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public PostBasicInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public PostBasicInfo setTitle(String title) {
        this.title = title;
        return this;
    }

    public LocalDateTime getDateOfPublication() {
        return dateOfPublication;
    }

    public PostBasicInfo setDateOfPublication(LocalDateTime dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
        return this;
    }

    public LocalDateTime getDateOfLastUpdate() {
        return dateOfLastUpdate;
    }

    public PostBasicInfo setDateOfLastUpdate(LocalDateTime dateOfLastUpdate) {
        this.dateOfLastUpdate = dateOfLastUpdate;
        return this;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public PostBasicInfo setExcerpt(String excerpt) {
        this.excerpt = excerpt;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public PostBasicInfo setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public PostBasicInfo setStatus(String status) {
        this.status = status;
        return this;
    }
}