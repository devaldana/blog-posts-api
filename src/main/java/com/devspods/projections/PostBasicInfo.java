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

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(LocalDateTime dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }

    public LocalDateTime getDateOfLastUpdate() {
        return dateOfLastUpdate;
    }

    public void setDateOfLastUpdate(LocalDateTime dateOfLastUpdate) {
        this.dateOfLastUpdate = dateOfLastUpdate;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}