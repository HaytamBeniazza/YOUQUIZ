package com.wi.quiz.DTO.Subject;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDto {
    private Long id;
    @NotNull
    private String name;
    private Long top_id;
}
