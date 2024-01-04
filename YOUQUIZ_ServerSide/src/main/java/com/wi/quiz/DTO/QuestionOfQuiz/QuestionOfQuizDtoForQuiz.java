package com.wi.quiz.DTO.QuestionOfQuiz;

import com.wi.quiz.DTO.Question.QuestionDto;
import com.wi.quiz.DTO.Question.QuestionDtoForShowValidation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionOfQuizDtoForQuiz {
    private Long id;
    private QuestionDtoForShowValidation question;
}
