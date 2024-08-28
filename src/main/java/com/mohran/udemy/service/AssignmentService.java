package com.mohran.udemy.service;

import com.mohran.udemy.ExceptionHandler.ResourceNotFoundException;
import com.mohran.udemy.dto.AssignmentDto;
import com.mohran.udemy.dto.LectureDto;
import com.mohran.udemy.model.Assignment;
import com.mohran.udemy.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssignmentService {
    @Autowired
    private AssignmentRepository assignmentRepository;
    @Autowired
    private ConvertAssignmentService convertAssignmentService;

    public AssignmentDto createAssignment(AssignmentDto assignmentDto)
    {
        Assignment assignment = convertAssignmentService.convertAssignmentDtoToAssignment(assignmentDto);
        Assignment savedAssignment = assignmentRepository.save(assignment);
        return convertAssignmentService.convertAssignmentToAssignmentDto(savedAssignment);
    }

    public List<AssignmentDto> getAssignments()
    {
        List<Assignment> assignments = assignmentRepository.findAll();
        return assignments.stream()
                .map(x->convertAssignmentService.convertAssignmentToAssignmentDto(x))
                .collect(Collectors.toList());
    }

    public AssignmentDto getAssignmentById(Long id){
        Assignment assignment = assignmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Assignment not found with id " + id));
        return convertAssignmentService.convertAssignmentToAssignmentDto(assignment);
    }

    public  AssignmentDto updateAssignment(Long id , AssignmentDto assignmentDto)
    {
        Assignment existingAssignment =  assignmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Assignment not found with id " + id));
        Assignment updateAssignment = convertAssignmentService.updateAssignmentFromDto(existingAssignment,assignmentDto);
        assignmentRepository.save(updateAssignment);
        return convertAssignmentService.convertAssignmentToAssignmentDto(updateAssignment);
    }

    public void deleteAssignment(Long id)
    {
        Assignment assignment = assignmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Assignment not found with id " + id));
        assignmentRepository.delete(assignment);
    }


}
