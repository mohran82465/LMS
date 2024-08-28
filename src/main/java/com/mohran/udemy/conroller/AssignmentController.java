package com.mohran.udemy.conroller;

import com.mohran.udemy.dto.AssignmentDto;
import com.mohran.udemy.dto.LectureDto;
import com.mohran.udemy.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignment")
public class AssignmentController {
    @Autowired
    private AssignmentService assignmentService ;



    @PostMapping
    public ResponseEntity<AssignmentDto> createLecture(@RequestBody AssignmentDto assignmentDto) {
        AssignmentDto createdAssignment = assignmentService.createAssignment(assignmentDto);
        return ResponseEntity.ok(createdAssignment);
    }

    @GetMapping
    public ResponseEntity<List<AssignmentDto>> getAllLectures() {
        List<AssignmentDto> assignments = assignmentService.getAssignments();
        return ResponseEntity.ok(assignments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssignmentDto> getLectureById(@PathVariable Long id) {
        AssignmentDto lecture = assignmentService.getAssignmentById(id);
        return ResponseEntity.ok(lecture);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssignmentDto> updateLecture(@PathVariable Long id, @RequestBody AssignmentDto assignmentDto) {
        AssignmentDto updatedAssignment = assignmentService.updateAssignment(id, assignmentDto);
        return ResponseEntity.ok(updatedAssignment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLecture(@PathVariable Long id) {
        assignmentService.deleteAssignment(id);
        return ResponseEntity.noContent().build();
    }

}
