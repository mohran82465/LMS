package com.mohran.udemy.service;

import com.mohran.udemy.dto.StudentSectionProgressDto;
import com.mohran.udemy.model.Section;
import com.mohran.udemy.model.Student;
import com.mohran.udemy.model.StudentSectionProgress;
import com.mohran.udemy.repository.SectionRepository;
import com.mohran.udemy.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvertStudentSectionProgressService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SectionRepository sectionRepository;

    public StudentSectionProgress convertDtoToEntity(StudentSectionProgressDto dto) {
        StudentSectionProgress progress = new StudentSectionProgress();

        progress.setId(dto.getId());

        Student student = studentRepository.findById(dto.getStudentId()).orElse(null);
        progress.setStudent(student);

        Section section = sectionRepository.findById(dto.getSectionId()).orElse(null);
        progress.setSection(section);

        progress.setCompleted(dto.isCompleted());

        return progress;
    }

    public StudentSectionProgressDto convertEntityToDto(StudentSectionProgress progress) {
        StudentSectionProgressDto dto = new StudentSectionProgressDto();

        dto.setId(progress.getId());
        dto.setStudentId(progress.getStudent().getId());
        dto.setSectionId(progress.getSection().getId());
        dto.setCompleted(progress.isCompleted());

        return dto;
    }
}
