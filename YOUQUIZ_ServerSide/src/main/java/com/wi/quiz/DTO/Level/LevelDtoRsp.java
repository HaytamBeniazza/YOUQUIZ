package com.wi.quiz.DTO.Level;

import com.wi.quiz.DTO.Question.QuestionDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LevelDtoRsp {
    private Long id;
    private String description;
    private int maxPoints;
    private int minPoints;
    private List<QuestionDto> questions;
}
