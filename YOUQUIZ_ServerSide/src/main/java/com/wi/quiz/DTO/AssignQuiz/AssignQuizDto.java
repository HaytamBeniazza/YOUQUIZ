package com.wi.quiz.DTO.AssignQuiz;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignQuizDto {

    private Long id;
    @NotNull
    private Long student_id;
    @NotNull
    private Long quiz_id;
    @NotNull
    private int score;
    @NotNull
    private int chance;
    @NotNull
    private String notes;
    private LocalDate date = LocalDate.now();
    private boolean played;
}
