package com.wi.quiz.DTO.Response;

import java.util.List;

import com.wi.quiz.DTO.Validation.ValidationDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseDtoRsp {
    private Long id;
    private String response;

    List<ValidationDto> validations;
}
