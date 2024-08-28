package com.mohran.udemy.service;

import com.mohran.udemy.dto.CourseDto;
import com.mohran.udemy.model.*;
import com.mohran.udemy.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ConvertCourseService {

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private CourseReviewRepository courseReviewRepository;


    public CourseDto convertCourseToCourseDto(Course course) {
        CourseDto courseDto = new CourseDto();
        courseDto.setId(course.getId());
        courseDto.setTitle(course.getTitle());
        courseDto.setInstructorId(course.getInstructor().getId());
        courseDto.setPrice(course.getPrice());
        courseDto.setCourseImg(course.getCourseImg());
        courseDto.setPromotionalVideo(course.getPromotionalVideo());
        courseDto.setStatus(course.getStatus());

        courseDto.setEnrolledStudentIds(course.getEnrolledStudents().stream().map(Student::getId).collect(Collectors.toSet()));
        courseDto.setCompletedByIds(course.getCompletedBy().stream().map(Student::getId).collect(Collectors.toSet()));
        courseDto.setWishlistedByIds(course.getWishlistedBy().stream().map(Student::getId).collect(Collectors.toSet()));
        courseDto.setFavouritedByIds(course.getFavouritedBy().stream().map(Student::getId).collect(Collectors.toSet()));
        courseDto.setContentIds(course.getContents().stream().map(Section::getId).collect(Collectors.toList()));
        courseDto.setApprovedByAdminId(course.getApprovedBy() != null ? course.getApprovedBy().getId() : null);
        courseDto.setReviewIds(course.getReviews().stream().map(CourseReview::getId).collect(Collectors.toList()));

        return courseDto;
    }

    public Course convertCourseDtoToCourse(CourseDto courseDto) {
        Course course = new Course();
        course.setId(courseDto.getId());
        course.setTitle(courseDto.getTitle());

        Instructor instructor = instructorRepository.findById(courseDto.getInstructorId())
                .orElseThrow(() -> new IllegalArgumentException("Instructor not found"));
        course.setInstructor(instructor);

        course.setPrice(courseDto.getPrice());
        course.setCourseImg(courseDto.getCourseImg());
        course.setPromotionalVideo(courseDto.getPromotionalVideo());

        Set<Student> enrolledStudents = courseDto.getEnrolledStudentIds().stream()
                .map(id -> studentRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("Student not found with id " + id)))
                .collect(Collectors.toSet());
        course.setEnrolledStudents(enrolledStudents);

        Set<Student> completedBy = courseDto.getCompletedByIds().stream()
                .map(id -> studentRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("Student not found with id " + id)))
                .collect(Collectors.toSet());
        course.setCompletedBy(completedBy);

        Set<Student> wishlistedBy = courseDto.getWishlistedByIds().stream()
                .map(id -> studentRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("Student not found with id " + id)))
                .collect(Collectors.toSet());
        course.setWishlistedBy(wishlistedBy);

        Set<Student> favouritedBy = courseDto.getFavouritedByIds().stream()
                .map(id -> studentRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("Student not found with id " + id)))
                .collect(Collectors.toSet());
        course.setFavouritedBy(favouritedBy);


        List<Section> contents = courseDto.getContentIds().stream()
                .map(id -> sectionRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("Section not found with id " + id)))
                .collect(Collectors.toList());
        course.setContents(contents);

        if (courseDto.getApprovedByAdminId() != null) {
            Admin admin = adminRepository.findById(courseDto.getApprovedByAdminId())
                    .orElseThrow(() -> new IllegalArgumentException("Admin not found"));
            course.setApprovedBy(admin);
        }

        List<CourseReview> reviews = courseDto.getReviewIds().stream()
                .map(id -> courseReviewRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("Review not found with id " + id)))
                .collect(Collectors.toList());
        course.setReviews(reviews);

        return course;
    }
}

