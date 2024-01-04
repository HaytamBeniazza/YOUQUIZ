package com.wi.quiz.DTO.Media;

import com.wi.quiz.Enums.MediaType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class MediaDto {
    private Long id;
    @NotNull
    private String src;
    @NotNull
    private MediaType type;
    @NotNull
    private Long question_id;
}
