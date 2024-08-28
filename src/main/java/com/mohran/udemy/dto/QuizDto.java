package com.mohran.udemy.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;
@Getter
@Setter
@Data
public class QuizDto {
    private Long id;
    private String Sectiontitle;
    private Long courseId;
    private List<Long> progressIds;
    private String name;
    private String description;
    private Set<QuestionDto> questions;
}

