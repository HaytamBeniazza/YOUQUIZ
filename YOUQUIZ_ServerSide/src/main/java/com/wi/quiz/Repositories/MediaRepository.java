package com.wi.quiz.Repositories;

import com.wi.quiz.DTO.Question.QuestionDto;
import com.wi.quiz.Entities.Media;
import com.wi.quiz.Enums.MediaType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MediaRepository extends JpaRepository<Media, Long> {
    Optional<Media> findBySrcAndTypeAndQuestionId(String src, MediaType type, Long questionId);
    Page<Media> findAll(Pageable pageable);
}