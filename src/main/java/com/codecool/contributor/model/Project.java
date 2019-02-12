package com.codecool.contributor.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Project {

    public enum Status {
        OPEN, INPROGRESS, CLOSED
    }

    @Id
    @GeneratedValue
    protected Integer id;

    @Column(nullable = false)
    protected String title;

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
    @Builder.Default
    private Status status = Status.OPEN;

    @Column(columnDefinition = "TEXT")
    private String image;

    @ManyToOne
    @JsonIgnoreProperties("projects")
    private User projectOwner;

    @ElementCollection
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnoreProperties("projects")
    @Singular
    private List<User> contributors;

    public boolean tagsContainCompareTag(List<String> compareTags) {
        for (String compareTag : compareTags) {
            if (this.tags.contains(compareTag))
                return true;
        }
        return false;
    }
}
