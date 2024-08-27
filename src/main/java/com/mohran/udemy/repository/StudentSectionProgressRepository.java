package com.mohran.udemy.repository;

import com.mohran.udemy.model.StudentSectionProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentSectionProgressRepository extends JpaRepository<StudentSectionProgress,Long> {
}
