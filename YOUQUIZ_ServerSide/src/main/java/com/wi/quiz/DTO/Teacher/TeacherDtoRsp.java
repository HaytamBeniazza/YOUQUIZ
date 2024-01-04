package com.wi.quiz.DTO.Teacher;

import com.wi.quiz.DTO.Person.PersonDto;
import com.wi.quiz.DTO.Quiz.QuizDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDtoRsp extends PersonDto {
    private String speciality;
    private List<QuizDto> quizzes;
}
