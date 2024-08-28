package com.mohran.udemy.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class QuestionDto {
    private Long id ;
    @NotEmpty
    @NotBlank
    @NotNull
    private String questionContent;
    @NotEmpty
    @NotBlank
    @NotNull
    private String options;
    @NotEmpty
    @NotBlank
    @NotNull
    private String correctAnswer;
    @NotEmpty
    @NotBlank
    @NotNull
    private Long quizId;

}
