package com.wi.quiz.Repositories;

import com.wi.quiz.Entities.Answer;
import com.wi.quiz.Entities.Level;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelRepository extends JpaRepository<Level, Long> {
    Page<Level> findAll(Pageable pageable);
}
