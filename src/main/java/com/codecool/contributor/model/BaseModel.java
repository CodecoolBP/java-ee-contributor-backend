package com.codecool.contributor.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Data
public class BaseModel {
    protected Integer id;
    @NotEmpty
    protected String name;
    protected String description;

    BaseModel(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
