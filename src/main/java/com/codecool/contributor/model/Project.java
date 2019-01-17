package com.codecool.contributor.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Project extends BaseModel {
    private String shortDesc;
    private String organisation;
    private String requirements;
    private List<String> tags;
    private EnumStatus status;

    public Project() {
    }

    public Project(String name, String description, String shortDesc, String organisation, String requirements, List<String> tags) {
        super(name, description);
        this.shortDesc = shortDesc;
        this.organisation = organisation;
        this.requirements = requirements;
        this.tags = tags;
        this.status = EnumStatus.OPEN;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
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

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public EnumStatus getStatus() {
        return status;
    }

    public void setStatus(EnumStatus status) {
        this.status = status;
    }

    public boolean tagsContainCompareTag(List<String> compareTags) {
        for (String compareTag : compareTags) {
            if (this.tags.contains(compareTag))
                return true;
        }
        return false;
    }
}
