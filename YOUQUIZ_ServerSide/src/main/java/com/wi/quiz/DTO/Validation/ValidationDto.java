package com.wi.quiz.DTO.Validation;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ValidationDto {
    private Long id;
    @NotNull
    private Long question_id;
    @NotNull
    private Long response_id;
    @NotNull
    private boolean isCorrect;
    @NotNull
    private int points;
}
