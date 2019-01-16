package com.codecool.contributor.model;

import java.util.List;

public class Project extends BaseModel {
    private String requirements;
    private List<String> tags;
    private EnumStatus status;

    public Project(String name, String description, String requirements, List<String> tags, EnumStatus status) {
        super(name, description);
        this.requirements = requirements;
        this.tags = tags;
        this.status = status;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public List<String> getTags() {
        return tags;
    }

    public String getTagByString(String tag) {
        return getTags().stream().filter(t -> );
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public EnumStatus getStatus() {
        return status;
    }

    public void setStatus(EnumStatus status) {
        this.status = status;
    }
}
