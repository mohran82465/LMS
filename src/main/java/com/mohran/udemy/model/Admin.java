package com.mohran.udemy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Admin extends User {
    @OneToMany(mappedBy = "approvedBy")
    private Set<Course> approvedCourses;
}
