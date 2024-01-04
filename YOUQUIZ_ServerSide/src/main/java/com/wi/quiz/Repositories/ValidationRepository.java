package com.wi.quiz.Repositories;

import com.wi.quiz.DTO.Validation.ValidationDtoRsp;
import com.wi.quiz.Entities.Teacher;
import com.wi.quiz.Entities.Validation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ValidationRepository extends JpaRepository<Validation, Long> {
    Optional<Validation> findByQuestionIdAndResponseId(Long questionId, Long responseId);
    Page<Validation> findAll(Pageable pageable);
}
