package com.example.springtutorial.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    //Student here is not the table per se. It's the entity within JPQL
    //@Query("SELECT s FROM Student s WHER s.email = - ?1")
    Optional<Student> findStudentByEmail(String email);
}
