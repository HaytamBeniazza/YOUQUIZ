package com.wi.quiz.DTO.Subject;

import com.wi.quiz.DTO.Question.QuestionDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDtoRsp {
    private Long id;
    private String name;
    private SubjectDto top;
    private List<SubjectDto> subs;
    private List<QuestionDto> questions;
}
