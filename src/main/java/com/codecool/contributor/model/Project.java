package com.codecool.contributor.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class Project extends BaseModel {
    private String shortDesc;
    private String organisation;
    private String requirements;
    private List<String> tags;
    private Status status;

    public Project(String name, String description, String shortDesc, String organisation, String requirements, List<String> tags) {
        super(name, description);
        this.shortDesc = shortDesc;
        this.organisation = organisation;
        this.requirements = requirements;
        this.tags = tags;
        this.status = Status.OPEN;
    }

    public boolean tagsContainCompareTag(List<String> compareTags) {
        for (String compareTag : compareTags) {
            if (this.tags.contains(compareTag))
                return true;
        }
        return false;
    }
}
