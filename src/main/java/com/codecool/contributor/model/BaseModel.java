package com.codecool.contributor.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Data
public class BaseModel {

    @Id
    @GeneratedValue
    protected Integer id;

    @Column(nullable = false)
    protected String title;

    @Column(nullable = false)
    protected String description;

    public BaseModel(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
