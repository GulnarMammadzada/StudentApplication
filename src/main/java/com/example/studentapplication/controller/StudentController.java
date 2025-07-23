package com.example.studentapplication.controller;

import com.example.studentapplication.dto.StudentDto;
import com.example.studentapplication.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public StudentDto createStudent(@RequestBody StudentDto studentDto){
        return studentService.createStudent(studentDto);
    }

    @GetMapping
    public List<StudentDto> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @PutMapping("/update/{id}")
    public StudentDto updateStudent(@PathVariable Long id, @RequestBody StudentDto studentDto){
        return studentService.updateStudent(id, studentDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
