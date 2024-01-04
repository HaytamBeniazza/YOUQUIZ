package com.wi.quiz.DTO.Media;

import com.wi.quiz.DTO.Question.QuestionDto;
import com.wi.quiz.Enums.MediaType;
import com.wi.quiz.Enums.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class MediaDtoRsp {
    private Long id;
    private String src;
    private MediaType type;
    private QuestionDto question;
}
