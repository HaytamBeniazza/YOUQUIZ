package com.wi.quiz.DTO.Level;

import com.wi.quiz.Entities.Question;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LevelDto {
    private Long id;
    @NotNull
    private String description;
    @NotNull
    private int maxPoints;
    @NotNull
    private int minPoints;
}
