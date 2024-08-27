package com.mohran.udemy.model;

import jakarta.persistence.Entity;
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
public class Lecture extends Section{
    private String name;
    private String content;
    private Double duration;
    private String resources;
    private Date createAt ;
    private Date updateAt;

}
