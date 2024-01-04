package com.wi.quiz.DTO.Answer;

import com.wi.quiz.DTO.AssignQuiz.AssignQuizDto;
import com.wi.quiz.DTO.Validation.ValidationDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDtoRsp {
    private Long id;
    private AssignQuizDto assignQuiz;
    private ValidationDto validation;
}
