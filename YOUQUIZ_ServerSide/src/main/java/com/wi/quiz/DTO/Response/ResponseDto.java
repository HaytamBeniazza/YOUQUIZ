package com.wi.quiz.DTO.Response;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class    ResponseDto {
     private Long id;
    @NotNull
    private String response;
}
