package com.mohran.udemy.conroller;

import com.mohran.udemy.ExceptionHandler.ResourceNotFoundException;
import com.mohran.udemy.dto.InstructorDto;
import com.mohran.udemy.dto.StudentDto;
import com.mohran.udemy.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/instructor")
public class InstructorController {
    @Autowired
    private InstructorService instructorService ;

    @GetMapping
    public ResponseEntity<List<InstructorDto>> getAllInstructors(){
        List<InstructorDto> instructors = instructorService.getAllInstructors();
        return ResponseEntity.ok(instructors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstructorDto> getInstructorById(@PathVariable Long id)
    {
        InstructorDto instructorDto = instructorService.getInstructorById(id);
        return ResponseEntity.ok(instructorDto);
    }

    @PostMapping
    public ResponseEntity<InstructorDto> createInstructor(@RequestBody InstructorDto instructorDto)
    {
        instructorService.saveInstructor(instructorDto);
        return ResponseEntity.ok(instructorDto);
    }
    @PutMapping("/{id}")
    public ResponseEntity<InstructorDto> updateInstructor(@PathVariable Long id ,@RequestBody InstructorDto upadteInstructorDto )
    {
        InstructorDto instructor = instructorService.updateInstructor(id,upadteInstructorDto);
        return ResponseEntity.ok(instructor);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstructor(@PathVariable Long id)
    {
        instructorService.deleteInstructor(id);
        return ResponseEntity.ok().build();
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
