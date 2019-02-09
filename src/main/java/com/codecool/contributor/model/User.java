package com.codecool.contributor.model;


import com.codecool.contributor.model.Project;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {

    public enum UserType {

        ORGANISATION,
        DEVELOPER,

    }

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false, unique = true)
    private  String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserType type;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST})
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnoreProperties("user")
    @Singular
    private Set<Project> projects;

}
