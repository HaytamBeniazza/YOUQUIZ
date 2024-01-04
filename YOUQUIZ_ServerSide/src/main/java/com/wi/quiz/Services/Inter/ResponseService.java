package com.wi.quiz.Services.Inter;

import com.wi.quiz.DTO.Response.ResponseDto;
import com.wi.quiz.DTO.Response.ResponseDtoRsp;
import com.wi.quiz.Services.BaseService;
import org.springframework.stereotype.Service;

@Service
public interface ResponseService extends BaseService<ResponseDtoRsp,ResponseDto, Long> {
}
