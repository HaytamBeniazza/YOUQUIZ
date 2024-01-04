package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.Quiz.QuizDto;
import com.wi.quiz.DTO.Quiz.QuizDtoRsp;
import com.wi.quiz.Entities.Quiz;
import com.wi.quiz.Entities.Teacher;
import com.wi.quiz.Exceptions.NotFoundEx;
import com.wi.quiz.Repositories.QuizRepository;
import com.wi.quiz.Repositories.TeacherRepository;
import com.wi.quiz.Services.Inter.QuizService;

import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {
    
    private final QuizRepository quizRepository;

    private final TeacherRepository teacherRepository;
    
    private final ModelMapper modelMapper;

    @Override
    public QuizDtoRsp save(QuizDto quizDto) {
        Quiz quiz = modelMapper.map(quizDto, Quiz.class);
        Teacher teacher= teacherRepository.findById(quizDto.getTeacher_id()).orElseThrow(() -> new NotFoundEx("Teacher not found for id: " + quizDto.getTeacher_id()));
        quiz.setTeacher(teacher);
        quiz = quizRepository.save(quiz);
        return modelMapper.map(quiz, QuizDtoRsp.class);
    }

    @Override
    public QuizDtoRsp update(QuizDto quizDto, Long aLong) {
        quizRepository.findById(aLong).orElseThrow(() -> new NotFoundEx("Quiz not found for id: " + aLong));
        Quiz quiz = modelMapper.map(quizDto, Quiz.class);
        Teacher teacher= teacherRepository.findById(quizDto.getTeacher_id()).orElseThrow(() -> new NotFoundEx("Teacher not found for id: " + quizDto.getTeacher_id()));
        quiz.setTeacher(teacher);
        quiz.setId(aLong);
        quiz = quizRepository.save(quiz);
        return modelMapper.map(quiz, QuizDtoRsp.class);
    }

    @Override
    public Boolean delete(Long aLong) {
        Optional<Quiz> optionalQuiz = quizRepository.findById(aLong);
        if (optionalQuiz.isEmpty()) {
            throw new NotFoundEx("Quiz not found for id: " + aLong);
        }
        quizRepository.deleteById(aLong);
        return quizRepository.findById(aLong).isEmpty();
    }

    @Override
    public QuizDtoRsp findOne(Long aLong) {
        Optional<Quiz> optionalQuiz = quizRepository.findById(aLong);
        if (optionalQuiz.isEmpty()) {
            throw new NotFoundEx("Quiz not found for id: " + aLong);
        }
        Quiz quiz = optionalQuiz.get();
        return modelMapper.map(quiz, QuizDtoRsp.class);
    }

    @Override
    public List<QuizDtoRsp> findAll() {
        List<Quiz> quizzes = quizRepository.findAll();
        return quizzes.stream().map(quiz -> modelMapper.map(quiz, QuizDtoRsp.class)).collect(java.util.stream.Collectors.toList());
    }
}
