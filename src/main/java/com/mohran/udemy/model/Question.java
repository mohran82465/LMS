package com.mohran.udemy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String questionContent;
    private String options;
    private String correctAnswer;
    private Date createAt;
    private Date updateAt;
    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;
}
