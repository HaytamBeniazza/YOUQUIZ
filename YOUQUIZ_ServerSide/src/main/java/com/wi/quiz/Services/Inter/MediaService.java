package com.wi.quiz.Services.Inter;

import com.wi.quiz.DTO.Media.MediaDto;
import com.wi.quiz.DTO.Media.MediaDtoRsp;
import com.wi.quiz.Services.BaseService;

public interface MediaService extends BaseService<MediaDtoRsp, MediaDto, Long> {
    void checkIfMediaExist(MediaDto mediaDto);
}
