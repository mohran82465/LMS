package com.mohran.udemy.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CourseReviewDto {
    private Long id;
    private Long studentId;
    private Long courseId;
    @Min(value = 1)
    @Max(value = 5)
    private int rating;
    private String comment;
    private Date reviewDate;
}
