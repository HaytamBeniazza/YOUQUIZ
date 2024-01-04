package com.wi.quiz.DTO.Answer;

import com.wi.quiz.DTO.Validation.ValidationDto;
import com.wi.quiz.DTO.Validation.ValidationDtoForShowValidation;
import com.wi.quiz.Entities.Validation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDtoForAssignQuiz {
    private Long id;
    private ValidationDtoForShowValidation validation;
}
