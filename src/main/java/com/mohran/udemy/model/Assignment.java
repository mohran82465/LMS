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
public class Assignment  extends Section{

    private String name ;
    private Date deadline;
    private String instructions;
    private Date createAt;
    private Date updatedAt;

}
