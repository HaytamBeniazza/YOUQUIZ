package com.wi.quiz.Services.Inter;

import com.wi.quiz.DTO.AssignQuiz.AssignQuizDto;
import com.wi.quiz.DTO.AssignQuiz.AssignQuizDtoRsp;
import com.wi.quiz.Services.BaseService;

public interface AssignQuizService extends BaseService<AssignQuizDtoRsp, AssignQuizDto, Long> {
    int getScore(Long id);
}
