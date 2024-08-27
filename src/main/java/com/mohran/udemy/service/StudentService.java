package com.mohran.udemy.service;

import com.mohran.udemy.ExceptionHandler.ResourceNotFoundException;
import com.mohran.udemy.dto.StudentDto;
import com.mohran.udemy.model.Student;
import com.mohran.udemy.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ConvertStudentService convertStudentService;
    public List<StudentDto> getAllStudents()
    {
        List<Student>  students = studentRepository.findAll();
        List<StudentDto> studentDtos = new ArrayList<>();
        for(Student student : students )
        {
            studentDtos.add(convertStudentService.convertStudentToStudentDto(student));
        }
        return studentDtos;
    }

    public StudentDto getStudentById(Long id)
    {
        StudentDto studentDto = convertStudentService.convertStudentToStudentDto(studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student not found with id " + id)));
        return  studentDto;
    }

    public StudentDto saveStudent(StudentDto studentDto)
    {
        Student student = convertStudentService.convertStudentDtoToStudent(studentDto);
        studentRepository.save(student);
        return studentDto;
    }

    public StudentDto updateStudent(Long id , StudentDto updateStudentDto)
    {
        Student student = convertStudentService.convertStudentDtoToStudent( getStudentById(id));
        studentRepository.save(student);
        return updateStudentDto;
    }


    public void deleteStudent(Long id){
        StudentDto studentDto = getStudentById(id);
        studentRepository.deleteById(id);
    }


}
