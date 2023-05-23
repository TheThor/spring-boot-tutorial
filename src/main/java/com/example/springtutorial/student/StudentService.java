package com.example.springtutorial.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent()) {
            //TODO:Should return a 409
            throw  new IllegalStateException("Email already exists");
        }
        studentRepository.save(student);

    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            //TODO:Should return a 409
            throw  new IllegalStateException("Student with id " + studentId + " doesn't exist");
        }
        studentRepository.deleteById(studentId);
    }


    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new IllegalStateException(
                        "Student with id  " + studentId + " does not exist."
                )
        );
        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }
        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException(
                        "Student with email " + email + " already exists."
                );
            }
            student.setEmail(email);
        }
    }
}
