package com.mohran.udemy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentSectionProgressDto {
    private Long id;
    private Long studentId;
    private Long sectionId;
    private boolean completed;
}
