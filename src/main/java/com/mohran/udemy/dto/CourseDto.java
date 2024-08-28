package com.mohran.udemy.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class CourseDto {
    private Long id;

    @NotBlank
    @NotNull
    private String title;

    @NotNull
    private Long instructorId;

    private Double price;
    private String courseImg;
    private String promotionalVideo;
    private String status;

    private Set<Long> enrolledStudentIds;
    private Set<Long> completedByIds;
    private Set<Long> wishlistedByIds;
    private Set<Long> favouritedByIds;

    private List<Long> contentIds;

    private Long approvedByAdminId;

    private List<Long> reviewIds;
}
