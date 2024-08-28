package com.mohran.udemy.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Setter
@Getter
public class LectureDto {
    private Long id;
    private String name;
    private String content;
    private Double duration;
    private String resources;
    private String Sectiontitle;
    private Long courseId;
    private List<Long> progressIds;
}
