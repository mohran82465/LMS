package com.mohran.udemy.service;

import com.mohran.udemy.dto.InstructorDto;
import com.mohran.udemy.model.Instructor;
import org.springframework.stereotype.Service;

@Service
public class ConvertInstructorService {

    public InstructorDto convertInstructorToInstructorDto(Instructor instructor) {
        InstructorDto instructorDto = new InstructorDto();

        if (instructor.getId() != null) {
            instructorDto.setId(instructor.getId());
        }

        if (instructor.getFirstName() != null) {
            instructorDto.setFirstName(instructor.getFirstName());
        }

        if (instructor.getLastName() != null) {
            instructorDto.setLastName(instructor.getLastName());
        }

        if (instructor.getEmail() != null) {
            instructorDto.setEmail(instructor.getEmail());
        }

        if (instructor.getPassword() != null) {
            instructorDto.setPassword(instructor.getPassword());
        }

        if (instructor.getProfilePicture() != null) {
            instructorDto.setProfilePicture(instructor.getProfilePicture());
        }

        if (instructor.getPhoneNumber() != null) {
            instructorDto.setPhoneNumber(instructor.getPhoneNumber());
        }

        if (instructor.getAddress() != null) {
            instructorDto.setAddress(instructor.getAddress());
        }

        if (instructor.getBio() != null) {
            instructorDto.setBio(instructor.getBio());
        }

        return instructorDto;
    }

    public Instructor convertInstructorDtoToInstructor(InstructorDto instructorDto) {
        Instructor instructor = new Instructor();

        if (instructorDto.getId() != null) {
            instructor.setId(instructorDto.getId());
        }

        if (instructorDto.getFirstName() != null) {
            instructor.setFirstName(instructorDto.getFirstName());
        }

        if (instructorDto.getLastName() != null) {
            instructor.setLastName(instructorDto.getLastName());
        }

        if (instructorDto.getEmail() != null) {
            instructor.setEmail(instructorDto.getEmail());
        }

        if (instructorDto.getPassword() != null) {
            instructor.setPassword(instructorDto.getPassword());
        }

        if (instructorDto.getProfilePicture() != null) {
            instructor.setProfilePicture(instructorDto.getProfilePicture());
        }

        if (instructorDto.getPhoneNumber() != null) {
            instructor.setPhoneNumber(instructorDto.getPhoneNumber());
        }

        if (instructorDto.getAddress() != null) {
            instructor.setAddress(instructorDto.getAddress());
        }

        if (instructorDto.getBio() != null) {
            instructor.setBio(instructorDto.getBio());
        }

        return instructor;
    }

    public Instructor update(InstructorDto instructorDto, Instructor instructor) {

        if (instructorDto.getFirstName() != null) {
            instructor.setFirstName(instructorDto.getFirstName());
        }

        if (instructorDto.getLastName() != null) {
            instructor.setLastName(instructorDto.getLastName());
        }

        if (instructorDto.getEmail() != null) {
            instructor.setEmail(instructorDto.getEmail());
        }

        if (instructorDto.getPassword() != null) {
            instructor.setPassword(instructorDto.getPassword());
        }

        if (instructorDto.getProfilePicture() != null) {
            instructor.setProfilePicture(instructorDto.getProfilePicture());
        }

        if (instructorDto.getPhoneNumber() != null) {
            instructor.setPhoneNumber(instructorDto.getPhoneNumber());
        }

        if (instructorDto.getAddress() != null) {
            instructor.setAddress(instructorDto.getAddress());
        }

        if (instructorDto.getBio() != null) {
            instructor.setBio(instructorDto.getBio());
        }

        return instructor;
    }
}
