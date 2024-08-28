package com.mohran.udemy.service;

import com.mohran.udemy.ExceptionHandler.ResourceNotFoundException;
import com.mohran.udemy.dto.CourseDto;
import com.mohran.udemy.model.*;
import com.mohran.udemy.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.*;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ConvertCourseService convertCourseService;

    public CourseDto createCourse(CourseDto courseDto) {
        Course course = convertCourseService.convertCourseDtoToCourse(courseDto);
        course.setStatus("Pending");
        Course savedCourse = courseRepository.save(course);
        return convertCourseService.convertCourseToCourseDto(savedCourse);
    }

    public CourseDto getCourseById(Long id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id));
        return convertCourseService.convertCourseToCourseDto(course);
    }

    public List<CourseDto> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream().map(x->convertCourseService.convertCourseToCourseDto(x)).collect(Collectors.toList());
    }

    public CourseDto updateCourse(Long id, CourseDto courseDto) {
        Course existingCourse = courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id));
        Course updatedCourse = convertCourseService.convertCourseDtoToCourse(courseDto);
        updatedCourse.setId(existingCourse.getId());
        updatedCourse.setStatus(existingCourse.getStatus());
        Course savedCourse = courseRepository.save(updatedCourse);
        return convertCourseService.convertCourseToCourseDto(savedCourse);
    }

    public void deleteCourse(Long id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id));

        courseRepository.delete(course);
    }

}
