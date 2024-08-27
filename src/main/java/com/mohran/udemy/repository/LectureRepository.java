package com.mohran.udemy.repository;

import com.mohran.udemy.model.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture,Long> {
}
