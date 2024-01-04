package com.wi.quiz.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.wi.quiz.Enums.QuestionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String question;
    private int numberOfAnswers;
    private int numberOfCorrectAnswers;
    private QuestionType questionType;
    private int points;
    private int time;
    @ManyToOne
    private Level level;
    @ManyToOne
    private Subject subject;
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Media> media;
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<QuestionOfQuiz> questionOfQuizs;
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Validation> validations;

    public Question(Long id) {
        this.id = id;
    }
}
