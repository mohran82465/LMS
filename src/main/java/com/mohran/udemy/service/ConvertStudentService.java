package com.mohran.udemy.service;

import com.mohran.udemy.dto.AdminDto;
import com.mohran.udemy.dto.StudentDto;
import com.mohran.udemy.model.Admin;
import com.mohran.udemy.model.Student;
import org.springframework.stereotype.Service;

@Service
public class ConvertStudentService {
    public StudentDto convertStudentToStudentDto(Student student)
    {
        StudentDto studentDto = new StudentDto();

        if(student.getId() != null) {
            studentDto.setId(student.getId());
        }

        if(student.getFirstName() != null) {
            studentDto.setFirstName(student.getFirstName());
        }

        if(student.getLastName() != null) {
            studentDto.setLastName(student.getLastName());
        }

        if(student.getEmail() != null) {
            studentDto.setEmail(student.getEmail());
        }

        if(student.getPassword() != null) {
            studentDto.setPassword(student.getPassword());
        }

        if(student.getProfilePicture() != null) {
            studentDto.setProfilePicture(student.getProfilePicture());
        }

        if(student.getPhoneNumber() != null) {
            studentDto.setPhoneNumber(student.getPhoneNumber());
        }

        if(student.getAddress() != null) {
            studentDto.setAddress(student.getAddress());
        }

        if(student.getBio() != null) {
            studentDto.setBio(student.getBio());
        }


        return studentDto;
    }
    public Student convertStudentDtoToStudent(StudentDto studentDto){
        Student student = new Student();
        if(studentDto.getId() != null) {
            student.setId(studentDto.getId());
        }

        if(studentDto.getFirstName() != null) {
            student.setFirstName(studentDto.getFirstName());
        }

        if(studentDto.getLastName() != null) {
            student.setLastName(studentDto.getLastName());
        }

        if(studentDto.getEmail() != null) {
            student.setEmail(studentDto.getEmail());
        }

        if(studentDto.getPassword() != null) {
            student.setPassword(studentDto.getPassword());
        }

        if(studentDto.getProfilePicture() != null) {
            student.setProfilePicture(studentDto.getProfilePicture());
        }

        if(studentDto.getPhoneNumber() != null) {
            student.setPhoneNumber(studentDto.getPhoneNumber());
        }

        if(studentDto.getAddress() != null) {
            student.setAddress(studentDto.getAddress());
        }

        if(studentDto.getBio() != null) {
            student.setBio(studentDto.getBio());
        }

        return student;
    }

    public Student update(StudentDto studentDto , Student student)
    {

        if(studentDto.getFirstName() != null) {
            student.setFirstName(studentDto.getFirstName());
        }

        if(studentDto.getLastName() != null) {
            student.setLastName(studentDto.getLastName());
        }

        if(studentDto.getEmail() != null) {
            student.setEmail(studentDto.getEmail());
        }

        if(studentDto.getPassword() != null) {
            student.setPassword(studentDto.getPassword());
        }

        if(studentDto.getProfilePicture() != null) {
            student.setProfilePicture(studentDto.getProfilePicture());
        }

        if(studentDto.getPhoneNumber() != null) {
            student.setPhoneNumber(studentDto.getPhoneNumber());
        }

        if(studentDto.getAddress() != null) {
            student.setAddress(studentDto.getAddress());
        }

        if(studentDto.getBio() != null) {
            student.setBio(studentDto.getBio());
        }

        return student;
    }

}
