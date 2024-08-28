package com.mohran.udemy.service;

import com.mohran.udemy.dto.CourseReviewDto;
import com.mohran.udemy.model.CourseReview;
import org.springframework.stereotype.Service;

@Service
public class ConvertCourseReviewService {

    public CourseReviewDto convertCourseReviewToCourseReviewDto(CourseReview courseReview) {
        CourseReviewDto dto = new CourseReviewDto();
        dto.setId(courseReview.getId());
        dto.setStudentId(courseReview.getStudent().getId());
        dto.setCourseId(courseReview.getCourse().getId());
        dto.setRating(courseReview.getRating());
        dto.setComment(courseReview.getComment());
        dto.setReviewDate(courseReview.getReviewDate());
        return dto;
    }

    public CourseReview convertCourseReviewDtoToCourseReview(CourseReviewDto courseReviewDto) {
        CourseReview courseReview = new CourseReview();
        courseReview.setId(courseReviewDto.getId());
        courseReview.setRating(courseReviewDto.getRating());
        courseReview.setComment(courseReviewDto.getComment());
        courseReview.setReviewDate(courseReviewDto.getReviewDate());
        return courseReview;
    }

    public CourseReview update(CourseReviewDto dto, CourseReview courseReview) {
        if (dto.getRating() != 0) {
            courseReview.setRating(dto.getRating());
        }
        if (dto.getComment() != null) {
            courseReview.setComment(dto.getComment());
        }
        if (dto.getReviewDate() != null) {
            courseReview.setReviewDate(dto.getReviewDate());
        }
        return courseReview;
    }
}
