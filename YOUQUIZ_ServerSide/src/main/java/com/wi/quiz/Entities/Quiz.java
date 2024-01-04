package com.wi.quiz.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private int successResult;
    private boolean answerAccess;
    private boolean resultAccess;
    private int numberOfChances;
    private String comment;
    @ManyToOne(fetch = FetchType.LAZY)
    private Teacher teacher;
    @OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<QuestionOfQuiz> questionOfQuizs;
    @OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AssignQuiz> assignQuizs;

    public Quiz(Long id) {
        this.id = id;
    }
}
