package com.example.springtutorial.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> listStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> listStudent(Long id) {
        return studentRepository.findById(id);
    }

    public void addNewStudent(Student student) {
        System.out.println(student);
        //studentRepository.save(student);
    }
}
