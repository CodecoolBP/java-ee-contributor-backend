package com.codecool.contributor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Data
@MappedSuperclass
public class BaseModel {

    @Id
    @GeneratedValue
    protected Integer id;

    @Column(nullable = false)
    protected String title;

    public BaseModel(String title) {
        this.title = title;
    }
}
