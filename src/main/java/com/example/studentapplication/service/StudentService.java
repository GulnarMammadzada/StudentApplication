package com.example.studentapplication.service;

import com.example.studentapplication.dto.StudentDto;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    StudentDto createStudent(StudentDto studentDto);
    StudentDto getStudentById(Long id);
    List<StudentDto> getAllStudents();
    StudentDto updateStudent(Long id,StudentDto studentDto);
    void deleteStudent(Long id);


}
