package com.codecool.contributor.entity;

import com.codecool.contributor.model.BaseModel;
import com.codecool.contributor.model.Status;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Project extends BaseModel {
    @Column(nullable = false, columnDefinition = "TEXT")
    protected String description;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String shortDesc;

    @Column(nullable = false)
    private String organisation;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String requirements;

    @ElementCollection
    @Singular
    private List<String> tags;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Lob
    @EqualsAndHashCode.Exclude
    @Column(columnDefinition = "mediumblob")
    private byte[] image;

    private Integer devId;

    @ManyToOne
    private User user;

    @Builder
    public Project(String title, String description, String shortDesc, String organisation, String requirements, List<String> tags) {
        super(title);
        this.description = description;
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
