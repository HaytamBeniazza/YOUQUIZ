package com.wi.quiz.Repositories;

import com.wi.quiz.Entities.Media;
import com.wi.quiz.Entities.QuestionOfQuiz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuestionOfQuizRepository extends JpaRepository<QuestionOfQuiz, Long> {
    Optional<QuestionOfQuiz> findByQuestionIdAndQuizId(Long questionId, Long quizId);
    Page<QuestionOfQuiz> findAll(Pageable pageable);
}
