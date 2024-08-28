package com.mohran.udemy.conroller;

import com.mohran.udemy.dto.StudentSectionProgressDto;
import com.mohran.udemy.service.StudentSectionProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student-section-progress")
public class StudentSectionProgressController {

    @Autowired
    private StudentSectionProgressService studentSectionProgressService;

    @PostMapping
    public ResponseEntity<StudentSectionProgressDto> createStudentSectionProgress(@RequestBody StudentSectionProgressDto dto) {
        StudentSectionProgressDto createdProgress = studentSectionProgressService.createStudentSectionProgress(dto);
        return ResponseEntity.ok(createdProgress);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentSectionProgressDto> updateStudentSectionProgress(@PathVariable Long id, @RequestBody StudentSectionProgressDto dto) {
        StudentSectionProgressDto updatedProgress = studentSectionProgressService.updateStudentSectionProgress(id, dto);
        if (updatedProgress != null) {
            return ResponseEntity.ok(updatedProgress);
        }
        return ResponseEntity.notFound().build(); // Handle not found case
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentSectionProgressDto> getStudentSectionProgressById(@PathVariable Long id) {
        StudentSectionProgressDto progress = studentSectionProgressService.getStudentSectionProgressById(id);
        if (progress != null) {
            return ResponseEntity.ok(progress);
        }
        return ResponseEntity.notFound().build(); // Handle not found case
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentSectionProgress(@PathVariable Long id) {
        studentSectionProgressService.deleteStudentSectionProgress(id);
        return ResponseEntity.noContent().build();
    }
}
