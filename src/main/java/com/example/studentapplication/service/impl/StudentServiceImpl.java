package com.example.studentapplication.service.impl;

import com.example.studentapplication.dto.StudentDto;
import com.example.studentapplication.entity.Student;
import com.example.studentapplication.repository.StudentRepo;
import com.example.studentapplication.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo){
        this.studentRepo=studentRepo;
    }

    @Override
    public StudentDto createStudent(StudentDto studentDto){
        Student student=new Student();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setAge(studentDto.getAge());
        student.setEmail(studentDto.getEmail());

        Student saved=studentRepo.save(student);

        return new StudentDto(saved.getId(),saved.getFirstName(),saved.getLastName(),saved.getAge(),saved.getEmail());


    }

    @Override
    public StudentDto getStudentById(Long id){
        Student student=studentRepo.findById(id).orElseThrow(()->new RuntimeException("Student not found"));

        return new StudentDto(id,student.getFirstName(),student.getLastName(),student.getAge(),student.getEmail());
    }


    @Override
    public List<StudentDto> getAllStudents(){
        return studentRepo.findAll()
                .stream()
                .map(student -> new StudentDto(student.getId(),student.getFirstName(),student.getFirstName(),student.getAge(),student.getEmail()))
                .collect((Collectors.toList()));
    }

    @Override
    public StudentDto updateStudent(Long id,StudentDto studentDto) {
        Student exist = studentRepo.findById(id).orElseThrow(()->new RuntimeException("Student not found"));

        exist.setFirstName(studentDto.getFirstName());
        exist.setLastName(studentDto.getLastName());
        exist.setAge(studentDto.getAge());
        exist.setEmail(studentDto.getEmail());

        Student updated=studentRepo.save(exist);

        return new StudentDto(updated.getId(),updated.getFirstName(),updated.getLastName(),updated.getAge(),updated.getEmail());


    }



    @Override
    public void deleteStudent(Long id){
        StudentDto data=getStudentById(id);
        if(data!= null){
            studentRepo.deleteById(id);
        }
    }
}
