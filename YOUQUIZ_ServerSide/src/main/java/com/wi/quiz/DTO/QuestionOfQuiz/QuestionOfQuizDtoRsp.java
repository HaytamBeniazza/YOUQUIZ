package com.wi.quiz.DTO.QuestionOfQuiz;

import com.wi.quiz.DTO.Question.QuestionDto;
import com.wi.quiz.DTO.Quiz.QuizDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionOfQuizDtoRsp {
    private Long id;
    private QuestionDto question;
    private QuizDto quiz;
}
