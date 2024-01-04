package com.wi.quiz.Services.Inter;

import com.wi.quiz.DTO.Answer.AnswerDto;
import com.wi.quiz.DTO.Answer.AnswerDtoRsp;
import com.wi.quiz.Entities.Answer;
import com.wi.quiz.Services.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AnswerService extends BaseService<AnswerDtoRsp, AnswerDto, Long> {
    List<AnswerDto> save(List<AnswerDto> answers);
}
