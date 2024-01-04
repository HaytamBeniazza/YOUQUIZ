package com.wi.quiz.Services.Inter;

import com.wi.quiz.DTO.Validation.ValidationDtoRsp;
import com.wi.quiz.DTO.Validation.ValidationDto;
import com.wi.quiz.Services.BaseService;

import java.util.Optional;

public interface ValidationService extends BaseService<ValidationDtoRsp, ValidationDto, Long> {

    void checkIfExist(Long question, Long response);
}
