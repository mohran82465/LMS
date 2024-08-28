package com.mohran.udemy.service;

import com.mohran.udemy.dto.AdminDto;
import com.mohran.udemy.dto.StudentDto;
import com.mohran.udemy.model.Admin;
import com.mohran.udemy.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ConvertStudentService {

    @Autowired
    private ConvertCourseService convertCourseService;
    @Autowired
    private ConvertCourseReviewService convertCourseReviewService;
    @Autowired
    private ConvertStudentSectionProgressService convertStudentSectionProgressService;


  public StudentDto convertStudentToStudentDto(Student student) {
        StudentDto studentDto = new StudentDto();

        studentDto.setId(student.getId());
        studentDto.setPassword(student.getPassword());
        studentDto.setEmail(student.getEmail());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setProfilePicture(student.getProfilePicture());
        studentDto.setPhoneNumber(student.getPhoneNumber());
        studentDto.setAddress(student.getAddress());
        studentDto.setBio(student.getBio());



        studentDto.setEnrollments(student.getEnrollments().stream()
                .map(x->convertCourseService.convertCourseToCourseDto(x))
                .collect(Collectors.toSet()));

        studentDto.setCompletedCourses(student.getCompletedCourses().stream()
                .map(x->convertCourseService.convertCourseToCourseDto(x))
                .collect(Collectors.toSet()));

        studentDto.setWishlistCourses(student.getWishlistCourses().stream()
                .map(x->convertCourseService.convertCourseToCourseDto(x))
                .collect(Collectors.toSet()));

        studentDto.setFavourites(student.getFavourites().stream()
                .map(x->convertCourseService.convertCourseToCourseDto(x))
                .collect(Collectors.toSet()));

        studentDto.setSectionProgress(student.getSectionProgress().stream()
                .map(convertStudentSectionProgressService::convertEntityToDto)
                .collect(Collectors.toList()));

        studentDto.setReviews(student.getReviews().stream()
                .map(x->convertCourseReviewService.convertCourseReviewToCourseReviewDto(x))
                .collect(Collectors.toList()));

        return studentDto;
    }


    public Student convertStudentDtoToStudent(StudentDto studentDto) {
        Student student = new Student();

        student.setId(studentDto.getId());
        student.setPassword(studentDto.getPassword());
        student.setEmail(studentDto.getEmail());
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setProfilePicture(studentDto.getProfilePicture());
        student.setPhoneNumber(studentDto.getPhoneNumber());
        student.setAddress(studentDto.getAddress());
        student.setBio(studentDto.getBio());


        student.setEnrollments(studentDto.getEnrollments().stream()
                .map(x->convertCourseService.convertCourseDtoToCourse(x))
                .collect(Collectors.toSet()));

        student.setCompletedCourses(studentDto.getCompletedCourses().stream()
                .map(x->convertCourseService.convertCourseDtoToCourse(x))
                .collect(Collectors.toSet()));

        student.setWishlistCourses(studentDto.getWishlistCourses().stream()
                .map(x->convertCourseService.convertCourseDtoToCourse(x))
                .collect(Collectors.toSet()));

        student.setFavourites(studentDto.getFavourites().stream()
                .map(x->convertCourseService.convertCourseDtoToCourse(x))
                .collect(Collectors.toSet()));

        student.setSectionProgress(studentDto.getSectionProgress().stream()
                .map(convertStudentSectionProgressService::convertDtoToEntity)
                .collect(Collectors.toList()));

        student.setReviews(studentDto.getReviews().stream()
                .map(x-> convertCourseReviewService.convertCourseReviewDtoToCourseReview(x))
                .collect(Collectors.toList()));

        return student;
    }


    public Student update(StudentDto studentDto, Student student) {
        student.setPassword(studentDto.getPassword());
        student.setEmail(studentDto.getEmail());
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setProfilePicture(studentDto.getProfilePicture());
        student.setPhoneNumber(studentDto.getPhoneNumber());
        student.setAddress(studentDto.getAddress());
        student.setBio(studentDto.getBio());

        // Update other fields similarly based on your logic

        return student;
    }

}
