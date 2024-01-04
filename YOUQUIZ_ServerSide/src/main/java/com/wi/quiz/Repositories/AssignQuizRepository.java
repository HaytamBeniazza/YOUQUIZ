package com.wi.quiz.Repositories;

import com.wi.quiz.Entities.AssignQuiz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssignQuizRepository extends JpaRepository<AssignQuiz, Long> {
    Page<AssignQuiz> findAll(Pageable pageable);
    Optional<AssignQuiz> findByStudentIdAndQuizId(Long studentId, Long quizId);

    // i want to find one assignQuiz by quizId that has the highest chance
    Optional<AssignQuiz> findFirstByQuizIdOrderByChanceDesc(Long quizId);

}
