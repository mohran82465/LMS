package com.mohran.udemy.service;

import com.mohran.udemy.dto.AdminDto;
import com.mohran.udemy.dto.InstructorDto;
import com.mohran.udemy.model.Admin;
import com.mohran.udemy.model.Instructor;
import org.springframework.stereotype.Service;

@Service
public class ConvertInstructorService {
    public InstructorDto convertInstructorToInstructorDto(Instructor instructor)
    {
        InstructorDto instructorDto = new InstructorDto();
        instructorDto.setId(instructor.getId());
        instructorDto.setFirstName(instructor.getFirstName());
        instructorDto.setLastName(instructor.getLastName());
        instructorDto.setEmail(instructor.getEmail());
        instructorDto.setPassword(instructor.getPassword());
        instructorDto.setProfilePicture(instructor.getProfilePicture());
        instructorDto.setPhoneNumber(instructor.getPhoneNumber());
        instructorDto.setAddress(instructor.getAddress());
        instructorDto.setBio(instructor.getBio());
        return instructorDto;
    }


    public Instructor convertInstructorDtoToInstructor(InstructorDto instructorDto){
        Instructor instructor = new Instructor();
        instructor.setId(instructorDto.getId());
        instructor.setFirstName(instructorDto.getFirstName());
        instructor.setLastName(instructorDto.getLastName());
        instructor.setEmail(instructorDto.getEmail());
        instructor.setPassword(instructorDto.getPassword());
        instructor.setProfilePicture(instructorDto.getProfilePicture());
        instructor.setPhoneNumber(instructorDto.getPhoneNumber());
        instructor.setAddress(instructorDto.getAddress());
        instructor.setBio(instructorDto.getBio());

        return instructor;
    }
}
