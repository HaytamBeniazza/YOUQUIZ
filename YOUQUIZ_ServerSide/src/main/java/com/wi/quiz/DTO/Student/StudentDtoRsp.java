package com.wi.quiz.DTO.Student;

import com.wi.quiz.DTO.AssignQuiz.AssignQuizDto;
import com.wi.quiz.DTO.Person.PersonDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDtoRsp extends PersonDto {
    private LocalDate enrollmentDate;
    private List<AssignQuizDto> quizzes;
}
