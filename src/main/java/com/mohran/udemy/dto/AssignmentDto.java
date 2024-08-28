package com.mohran.udemy.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Data
public class AssignmentDto {
    private Long id ;
    private String name;
    private Date deadline;
    private String instructions;
    private String Sectiontitle;
    private Long courseId;
    private List<Long> progressIds;

}
