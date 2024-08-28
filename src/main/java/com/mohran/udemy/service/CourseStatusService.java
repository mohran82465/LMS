package com.mohran.udemy.service;

import com.mohran.udemy.ExceptionHandler.ResourceNotFoundException;
import com.mohran.udemy.dto.CourseDto;
import com.mohran.udemy.model.Course;
import com.mohran.udemy.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseStatusService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ConvertCourseService convertCourseService;


    public CourseDto approveCourse(Long id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id));
        course.setStatus("Approved");
        Course approvedCourse = courseRepository.save(course);
        return convertCourseService.convertCourseToCourseDto(approvedCourse);
    }

    public CourseDto rejectCourse(Long id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id));
        course.setStatus("Rejected");
        Course rejectedCourse = courseRepository.save(course);
        return convertCourseService.convertCourseToCourseDto(rejectedCourse);
    }
}
