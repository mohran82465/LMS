package com.mohran.udemy.conroller;

import com.mohran.udemy.dto.CourseReviewDto;
import com.mohran.udemy.service.CourseReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course-reviews")
public class CourseReviewController {

    @Autowired
    private CourseReviewService courseReviewService;

    @PostMapping
    public ResponseEntity<CourseReviewDto> createCourseReview(@RequestBody CourseReviewDto courseReviewDto) {
        CourseReviewDto createdReview = courseReviewService.createCourseReview(courseReviewDto);
        return ResponseEntity.ok(createdReview);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseReviewDto> getCourseReviewById(@PathVariable Long id) {
        CourseReviewDto courseReview = courseReviewService.getCourseReviewById(id);
        return ResponseEntity.ok(courseReview);
    }

    @GetMapping
    public ResponseEntity<List<CourseReviewDto>> getAllCourseReviews() {
        List<CourseReviewDto> courseReviews = courseReviewService.getAllCourseReviews();
        return ResponseEntity.ok(courseReviews);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseReviewDto> updateCourseReview(@PathVariable Long id, @RequestBody CourseReviewDto courseReviewDto) {
        CourseReviewDto updatedReview = courseReviewService.updateCourseReview(id, courseReviewDto);
        return ResponseEntity.ok(updatedReview);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourseReview(@PathVariable Long id) {
        courseReviewService.deleteCourseReview(id);
        return ResponseEntity.noContent().build();
    }
}
