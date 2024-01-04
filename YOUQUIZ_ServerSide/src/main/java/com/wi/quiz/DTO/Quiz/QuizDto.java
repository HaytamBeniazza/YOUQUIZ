package com.wi.quiz.DTO.Quiz;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizDto {
    private Long id;
    @NotNull
    private int successResult;
    @NotNull
    private boolean answerAccess;
    @NotNull
    private boolean resultAccess;
    @NotNull
    private int numberOfChances;
    @NotNull
    private String comment;
    @NotNull
    private Long teacher_id;
}
