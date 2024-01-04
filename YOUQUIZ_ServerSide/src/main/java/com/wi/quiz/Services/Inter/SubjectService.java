package com.wi.quiz.Services.Inter;

import com.wi.quiz.DTO.Subject.SubjectDtoRsp;
import com.wi.quiz.DTO.Subject.SubjectDto;
import com.wi.quiz.Services.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SubjectService  extends BaseService<SubjectDtoRsp,SubjectDto, Long>{
    //Page<SubjectDtoRsp> findAll(Pageable pageable);
}
