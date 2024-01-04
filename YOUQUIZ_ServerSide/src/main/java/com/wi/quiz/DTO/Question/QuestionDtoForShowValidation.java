package com.wi.quiz.DTO.Question;

import com.wi.quiz.DTO.Level.LevelDto;
import com.wi.quiz.DTO.Media.MediaDto;
import com.wi.quiz.DTO.QuestionOfQuiz.QuestionOfQuizDto;
import com.wi.quiz.DTO.Subject.SubjectDto;
import com.wi.quiz.DTO.Validation.ValidationDto;
import com.wi.quiz.DTO.Validation.ValidationDtoForShowValidation;
import com.wi.quiz.Enums.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuestionDtoForShowValidation {
    private Long id;
    private String question;
    private int numberOfAnswers;
    private int numberOfCorrectAnswers;
    private QuestionType questionType;
    private int points;
    private int time;
    private LevelDto level;
    private SubjectDto subject;
    private List<ValidationDtoForShowValidation> validations;
    private List<MediaDto> media;
    //private List<QuestionOfQuizDto> questionOfQuizs;
}
