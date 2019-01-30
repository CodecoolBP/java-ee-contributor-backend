package com.codecool.contributor.model;

import javax.validation.constraints.NotEmpty;

public class BaseModel {
    protected Integer id;
    @NotEmpty
    protected String name;
    protected String description;

    public BaseModel() {
    }

    public BaseModel(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
