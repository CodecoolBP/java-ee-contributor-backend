package com.codecool.contributor.entity;

import com.codecool.contributor.model.BaseModel;
import com.codecool.contributor.model.Status;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Project extends BaseModel {



    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String shortDesc;

    @Column(nullable = false)
    private String organisation;

    @Column(nullable = false)
    private String requirements;

    @ElementCollection
    @Singular
    private List<String> tags;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Lob
    @Column(columnDefinition = "mediumblob")
    private byte[] image;

    @Singular
    @ManyToOne
    private Long devId;

    @Singular
    @ManyToOne
    private Long orgId;



    public boolean tagsContainCompareTag(List<String> compareTags) {
        for (String compareTag : compareTags) {
            if (this.tags.contains(compareTag))
                return true;
        }
        return false;
    }
}