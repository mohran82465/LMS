package com.mohran.udemy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    private Double price;
    private String courseImg;
    private String promotionalVideo;
    private Date createAt;
    private Date updatedAt;

    private String status;


    @ManyToMany(mappedBy = "enrollments")
    private Set<Student> enrolledStudents;

    @ManyToMany(mappedBy = "completedCourses")
    private Set<Student> completedBy;

    @ManyToMany(mappedBy = "wishlistCourses")
    private Set<Student> wishlistedBy;

    @ManyToMany(mappedBy = "favourites")
    private Set<Student> favouritedBy;

     @OneToMany(mappedBy = "course")
     private List<Section> contents;

    @ManyToOne
    @JoinColumn(name = "approved_by_admin_id")
    private Admin approvedBy;


    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<CourseReview> reviews;
}

