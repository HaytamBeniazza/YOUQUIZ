package com.wi.quiz.Services;
import org.springframework.data.domain.*;

import java.util.List;
import java.util.Map;

public interface BaseService<DTO_RSP, DTO_MINI, F> {
    DTO_RSP save(DTO_MINI dtoMini);

    DTO_RSP update(DTO_MINI dtoMini, F f);

    Boolean delete(F f);

    DTO_RSP findOne(F f);

    List<DTO_RSP> findAll();
}