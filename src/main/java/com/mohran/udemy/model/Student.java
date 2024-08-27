package com.mohran.udemy.model;

import com.mohran.udemy.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student extends User {
    @ManyToMany
    @JoinTable(
            name = "student_enrollments",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> enrollments;

    @ManyToMany
    @JoinTable(
            name = "student_completed_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> completedCourses;

    @ManyToMany
    @JoinTable(
            name = "student_wishlist",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> wishlistCourses;

    @ManyToMany
    @JoinTable(
            name = "student_favourites",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> favourites;


    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<StudentSectionProgress> sectionProgress;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<CourseReview> reviews;
}
