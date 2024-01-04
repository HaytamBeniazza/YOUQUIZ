package com.wi.quiz.DTO.Answer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AnswerDto {
    private Long id;
    private Long validation_id;
    private Long assignQuiz_id;
}