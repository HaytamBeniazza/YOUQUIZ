package com.wi.quiz.Repositories;

import com.wi.quiz.Entities.Response;
import com.wi.quiz.Entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Page<Student> findAll(Pageable pageable);
}
