package com.mohran.udemy.repository;

import com.mohran.udemy.model.CourseReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<CourseReview,Long> {
}
