package com.codecool.contributor.entity;


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

    @Column(nullable = false)
    private UserType type;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST})
    @EqualsAndHashCode.Exclude
    @Singular
    private Set<Project> projects;







}
