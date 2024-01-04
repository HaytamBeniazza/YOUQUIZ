package com.wi.quiz.DTO.Validation;

import com.wi.quiz.DTO.Answer.AnswerDto;
import com.wi.quiz.DTO.Question.QuestionDto;
import com.wi.quiz.DTO.Response.ResponseDto;
import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ValidationDtoForShowValidation {
    private Long id;
    private ResponseDto response;
    //private boolean isCorrect;
    //private int points;
}
