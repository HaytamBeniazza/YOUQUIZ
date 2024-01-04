package com.wi.quiz.Repositories;

import com.wi.quiz.Entities.Student;
import com.wi.quiz.Entities.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Page<Subject> findAll(Pageable pageable);
}
