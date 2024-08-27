package com.mohran.udemy.service;

import com.mohran.udemy.ExceptionHandler.ResourceNotFoundException;
import com.mohran.udemy.dto.InstructorDto;
import com.mohran.udemy.model.Instructor;
import com.mohran.udemy.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstructorService {
    @Autowired
    private InstructorRepository instructorRepository;
    @Autowired
    private ConvertInstructorService convertInstructorService;


    public List<InstructorDto> getAllInstructors(){
        List<Instructor> instructors = instructorRepository.findAll();
        List<InstructorDto> instructorDtos = new ArrayList<>();
        for (Instructor instructor: instructors)
        {
            instructorDtos.add(convertInstructorService.convertInstructorToInstructorDto(instructor));
        }
        return instructorDtos;
    }

    public  InstructorDto getInstructorById(Long id)
    {
        InstructorDto instructorDto = convertInstructorService.convertInstructorToInstructorDto(instructorRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Instructor not found with id " + id)));
        return instructorDto;
    }
    public InstructorDto saveInstructor (InstructorDto instructorDto)
    {
        Instructor instructor = convertInstructorService.convertInstructorDtoToInstructor(instructorDto);
        instructorRepository.save(instructor);
        return instructorDto;
    }
    public InstructorDto updateInstructor(Long id , InstructorDto updateInstructorDto){
        Instructor instructor = convertInstructorService.convertInstructorDtoToInstructor(getInstructorById(id));
        instructorRepository.save(instructor);
        return updateInstructorDto;
    }

    public void deleteInstructor(Long id)
    {
        InstructorDto instructorDto =  getInstructorById(id);
        instructorRepository.deleteById(id);
    }



}
