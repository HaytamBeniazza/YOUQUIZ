package com.wi.quiz.DTO.Question;

import com.wi.quiz.Enums.QuestionType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuestionDto {
    private Long id;
    @NotNull
    private String question;
    @NotNull
    private int numberOfAnswers;
    @NotNull
    private int numberOfCorrectAnswers;
    @NotNull
    private QuestionType questionType;
    @NotNull
    private int points;
    @NotNull
    private int time;
    @NotNull
    private Long level_id;
    @NotNull
    private Long subject_id;
}
