package com.devspods.projections;

import java.time.LocalDateTime;

public class PostBasicInfo {

    private long id;
    private String title;
    private LocalDateTime dateOfCreation;

    public PostBasicInfo(){}

    public PostBasicInfo(long id, String title, LocalDateTime dateOfCreation) {
        this.id = id;
        this.title = title;
        this.dateOfCreation = dateOfCreation;
    }

    public long getId() {
        return id;
    }

    public PostBasicInfo setId(long id) {
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

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public PostBasicInfo setDateOfCreation(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
        return this;
    }
}