package com.wi.quiz.Repositories;

import com.wi.quiz.Entities.Answer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNullApi;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    Page<Answer> findAll(Pageable pageable);
}