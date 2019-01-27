package com.codecool.contributor.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Data
public class BaseModel {
    protected int id;
    @NotEmpty
    protected String name;
    protected String description;

    public BaseModel(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
