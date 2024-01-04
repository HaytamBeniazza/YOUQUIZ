package com.wi.quiz.Services.Inter;

import com.wi.quiz.DTO.QuestionOfQuiz.QuestionOfQuizDto;
import com.wi.quiz.DTO.QuestionOfQuiz.QuestionOfQuizDtoRsp;
import com.wi.quiz.Services.BaseService;

public interface QuestionOfQuizService extends BaseService<QuestionOfQuizDtoRsp, QuestionOfQuizDto, Long> {

    void checkIfExist(QuestionOfQuizDto questionOfQuizDto);
}
