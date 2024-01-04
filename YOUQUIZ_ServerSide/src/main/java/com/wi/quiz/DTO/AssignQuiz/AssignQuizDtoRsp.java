package com.wi.quiz.DTO.AssignQuiz;

import com.wi.quiz.DTO.Answer.AnswerDto;
import com.wi.quiz.DTO.Answer.AnswerDtoForAssignQuiz;
import com.wi.quiz.DTO.Quiz.QuizDto;
import com.wi.quiz.DTO.Student.StudentDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignQuizDtoRsp {
    private Long id;
    private StudentDto student;
    private QuizDto quiz;
    private int score;
    private int chance;
    private String notes;
    private LocalDate date;
    private List<AnswerDtoForAssignQuiz> answers;
    private boolean played;
}
