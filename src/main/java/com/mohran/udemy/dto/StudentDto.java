package com.mohran.udemy.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class StudentDto {
    private Long id;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String profilePicture;
    private String phoneNumber;
    private String address;
    private String bio;
    private Set<CourseDto> enrollments;
    private Set<CourseDto> completedCourses;
    private Set<CourseDto> wishlistCourses;
    private Set<CourseDto> favourites;
    private List<StudentSectionProgressDto> sectionProgress;
    private List<CourseReviewDto> reviews;
}
