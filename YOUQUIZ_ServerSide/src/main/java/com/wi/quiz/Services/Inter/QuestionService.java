package com.wi.quiz.Services.Inter;

import com.wi.quiz.DTO.Question.QuestionDto;
import com.wi.quiz.DTO.Question.QuestionDtoRsp;
import com.wi.quiz.Services.BaseService;
import org.springframework.stereotype.Service;

@Service
public interface QuestionService extends BaseService<QuestionDtoRsp, QuestionDto, Long> {
}