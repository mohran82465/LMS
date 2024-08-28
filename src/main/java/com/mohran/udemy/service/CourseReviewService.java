package com.mohran.udemy.service;

import com.mohran.udemy.ExceptionHandler.ResourceNotFoundException;
import com.mohran.udemy.dto.CourseReviewDto;
import com.mohran.udemy.model.Course;
import com.mohran.udemy.model.CourseReview;
import com.mohran.udemy.model.Student;
import com.mohran.udemy.repository.CourseRepository;
import com.mohran.udemy.repository.CourseReviewRepository;
import com.mohran.udemy.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseReviewService {

    @Autowired
    private CourseReviewRepository courseReviewRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ConvertCourseReviewService convertCourseReviewService;

    public CourseReviewDto createCourseReview(CourseReviewDto courseReviewDto) {
        Student student = studentRepository.findById(courseReviewDto.getStudentId())
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + courseReviewDto.getStudentId()));

        Course course = courseRepository.findById(courseReviewDto.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + courseReviewDto.getCourseId()));

        CourseReview courseReview = convertCourseReviewService.convertCourseReviewDtoToCourseReview(courseReviewDto);
        courseReview.setStudent(student);
        courseReview.setCourse(course);

        CourseReview savedCourseReview = courseReviewRepository.save(courseReview);
        return convertCourseReviewService.convertCourseReviewToCourseReviewDto(savedCourseReview);
    }

    public List<CourseReviewDto> getAllCourseReviews() {
        List<CourseReview> courseReviews = courseReviewRepository.findAll();
        List<CourseReviewDto> courseReviewDtos = new ArrayList<>();

        for (CourseReview courseReview : courseReviews) {
            courseReviewDtos.add(convertCourseReviewService.convertCourseReviewToCourseReviewDto(courseReview));
        }

        return courseReviewDtos;
    }

    public CourseReviewDto getCourseReviewById(Long id) {
        CourseReview courseReview = courseReviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CourseReview not found with id " + id));
        return convertCourseReviewService.convertCourseReviewToCourseReviewDto(courseReview);
    }

    public CourseReviewDto updateCourseReview(Long id, CourseReviewDto courseReviewDto) {
        CourseReview existingCourseReview = courseReviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CourseReview not found with id " + id));

        CourseReview updatedCourseReview = convertCourseReviewService.update(courseReviewDto, existingCourseReview);
        courseReviewRepository.save(updatedCourseReview);

        return convertCourseReviewService.convertCourseReviewToCourseReviewDto(updatedCourseReview);
    }

    public void deleteCourseReview(Long id) {
        CourseReview courseReview = courseReviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CourseReview not found with id " + id));
        courseReviewRepository.delete(courseReview);
    }
}
