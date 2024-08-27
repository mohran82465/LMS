package com.mohran.udemy.repository;

import com.mohran.udemy.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
