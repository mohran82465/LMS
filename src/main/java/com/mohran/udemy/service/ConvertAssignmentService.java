package com.mohran.udemy.service;

import com.mohran.udemy.ExceptionHandler.ResourceNotFoundException;
import com.mohran.udemy.dto.AssignmentDto;
import com.mohran.udemy.model.Assignment;
import com.mohran.udemy.model.StudentSectionProgress;
import com.mohran.udemy.repository.CourseRepository;
import com.mohran.udemy.repository.StudentSectionProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ConvertAssignmentService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentSectionProgressRepository progressRepository;

    public Assignment convertAssignmentDtoToAssignment(AssignmentDto assignmentDto)
    {
        Assignment assignment = new Assignment();
        assignment.setId(assignmentDto.getId());
        assignment.setName(assignmentDto.getName());
        assignment.setDeadline(assignmentDto.getDeadline());
        assignment.setInstructions(assignmentDto.getInstructions());
        assignment.setSectiontitle(assignmentDto.getSectiontitle());
        assignment.setCourse(courseRepository.findById(assignmentDto.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + assignmentDto.getCourseId())));
        assignment.setProgress(progressRepository.findAllById(assignmentDto.getProgressIds()));
        return assignment;
    }

    public AssignmentDto convertAssignmentToAssignmentDto(Assignment assignment)
    {
        AssignmentDto assignmentDto = new AssignmentDto();
        assignmentDto.setId(assignment.getId());
        assignmentDto.setName(assignment.getName());
        assignmentDto.setDeadline(assignment.getDeadline());
        assignmentDto.setInstructions(assignment.getInstructions());
        assignmentDto.setSectiontitle(assignment.getSectiontitle());
        assignmentDto.setCourseId(assignment.getCourse().getId());
        assignmentDto.setProgressIds(assignment.getProgress().stream()
                .map(StudentSectionProgress::getId)
                .collect(Collectors.toList()));
        return assignmentDto;
    }

    public Assignment updateAssignmentFromDto(Assignment assignment , AssignmentDto assignmentDto)
    {
        assignment.setId(assignmentDto.getId());
        assignment.setName(assignmentDto.getName());
        assignment.setDeadline(assignmentDto.getDeadline());
        assignment.setInstructions(assignmentDto.getInstructions());
        assignment.setSectiontitle(assignmentDto.getSectiontitle());
        assignment.setCourse(courseRepository.findById(assignmentDto.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + assignmentDto.getCourseId())));
        assignment.setProgress(progressRepository.findAllById(assignmentDto.getProgressIds()));
        return assignment;

    }

}
