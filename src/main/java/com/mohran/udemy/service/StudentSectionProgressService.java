package com.mohran.udemy.service;

import com.mohran.udemy.ExceptionHandler.ResourceNotFoundException;
import com.mohran.udemy.dto.StudentSectionProgressDto;
import com.mohran.udemy.model.Section;
import com.mohran.udemy.model.Student;
import com.mohran.udemy.model.StudentSectionProgress;
import com.mohran.udemy.repository.SectionRepository;
import com.mohran.udemy.repository.StudentRepository;
import com.mohran.udemy.repository.StudentSectionProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentSectionProgressService {

    @Autowired
    private StudentSectionProgressRepository studentSectionProgressRepository;

    @Autowired
    private ConvertStudentSectionProgressService convertService;


    public StudentSectionProgressDto createStudentSectionProgress(StudentSectionProgressDto dto) {
        StudentSectionProgress progress = convertService.convertDtoToEntity(dto);
        StudentSectionProgress savedProgress = studentSectionProgressRepository.save(progress);
        return convertService.convertEntityToDto(savedProgress);
    }

    public StudentSectionProgressDto updateStudentSectionProgress(Long id, StudentSectionProgressDto dto) {
            StudentSectionProgress existingProgress = studentSectionProgressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quiz not found with id " + id));
            existingProgress.setCompleted(dto.isCompleted());
            StudentSectionProgress savedProgress = studentSectionProgressRepository.save(existingProgress);
            return convertService.convertEntityToDto(savedProgress);
    }

    public StudentSectionProgressDto getStudentSectionProgressById(Long id) {
        StudentSectionProgress existingProgress = studentSectionProgressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quiz not found with id " + id));
        return convertService.convertEntityToDto(existingProgress);
    }

    public void deleteStudentSectionProgress(Long id) {

        StudentSectionProgress existingProgress = studentSectionProgressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quiz not found with id " + id));
        studentSectionProgressRepository.delete(existingProgress);
    }
}
