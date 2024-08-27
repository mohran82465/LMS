package com.mohran.udemy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Section {
    @Id
    private Long id;
    private String title ;

    @ManyToOne
    private Course course;

    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL)
    private List<StudentSectionProgress> progress;
}

