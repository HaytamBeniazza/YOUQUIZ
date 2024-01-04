package com.wi.quiz.DTO.Quiz;

import com.wi.quiz.DTO.AssignQuiz.AssignQuizDto;
import com.wi.quiz.DTO.QuestionOfQuiz.QuestionOfQuizDto;
import com.wi.quiz.DTO.QuestionOfQuiz.QuestionOfQuizDtoForQuiz;
import com.wi.quiz.DTO.Teacher.TeacherDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizDtoRsp {
    private Long id;
    private int successResult;
    private boolean answerAccess;
    private boolean resultAccess;
    private int numberOfChances;
    private String comment;
    private TeacherDto teacher;
    private List<QuestionOfQuizDtoForQuiz> questionOfQuizs;
    private List<AssignQuizDto> assignQuizs;
}
