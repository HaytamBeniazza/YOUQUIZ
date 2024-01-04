package com.wi.quiz.DTO.Validation;

import com.wi.quiz.DTO.Answer.AnswerDto;
import com.wi.quiz.DTO.Question.QuestionDto;
import com.wi.quiz.DTO.Response.ResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ValidationDtoRsp {
    private Long id;
    private QuestionDto question;
    private ResponseDto response;
    private List<AnswerDto> answers;
    private boolean isCorrect;
    private int points;
}
