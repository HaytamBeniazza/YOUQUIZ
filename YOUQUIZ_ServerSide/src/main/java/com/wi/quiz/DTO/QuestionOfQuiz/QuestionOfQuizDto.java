package com.wi.quiz.DTO.QuestionOfQuiz;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionOfQuizDto {
    private Long id;
    @NotNull
    private Long question_id;
    @NotNull
    private Long quiz_id;
}
