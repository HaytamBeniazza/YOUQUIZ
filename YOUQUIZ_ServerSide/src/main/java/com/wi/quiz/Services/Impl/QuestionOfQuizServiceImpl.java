package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.QuestionOfQuiz.QuestionOfQuizDto;
import com.wi.quiz.DTO.QuestionOfQuiz.QuestionOfQuizDtoRsp;
import com.wi.quiz.Entities.Question;
import com.wi.quiz.Entities.QuestionOfQuiz;
import com.wi.quiz.Entities.Quiz;
import com.wi.quiz.Exceptions.NotFoundEx;
import com.wi.quiz.Repositories.QuestionOfQuizRepository;
import com.wi.quiz.Repositories.QuestionRepository;
import com.wi.quiz.Repositories.QuizRepository;
import com.wi.quiz.Services.Inter.QuestionOfQuizService;

import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionOfQuizServiceImpl implements QuestionOfQuizService {

    private final QuestionOfQuizRepository questionOfQuizRepository;
    private  final QuizRepository quizRepository;
    private  final QuestionRepository questionRepository;

    private final ModelMapper modelMapper;

    @Override
    public QuestionOfQuizDtoRsp save(QuestionOfQuizDto questionOfQuizDto) {
        QuestionOfQuiz questionOfQuiz = modelMapper.map(questionOfQuizDto, QuestionOfQuiz.class);
        checkIfExist(questionOfQuizDto);
        Question question = questionRepository.findById(questionOfQuizDto.getQuestion_id()).orElseThrow(() -> new NotFoundEx("Question not found for id: " + questionOfQuizDto.getQuestion_id()));
        Quiz quiz = quizRepository.findById(questionOfQuizDto.getQuiz_id()).orElseThrow(() -> new NotFoundEx("Quiz not found for id: " + questionOfQuizDto.getQuiz_id()));
        questionOfQuiz.setQuestion(question);
        questionOfQuiz.setQuiz(quiz);
        questionOfQuiz = questionOfQuizRepository.save(questionOfQuiz);
        return modelMapper.map(questionOfQuiz, QuestionOfQuizDtoRsp.class);
    }

    @Override
    public QuestionOfQuizDtoRsp update(QuestionOfQuizDto questionOfQuizDto, Long aLong) {
        questionOfQuizRepository.findById(aLong).orElseThrow(() -> new NotFoundEx("QuestionOfQuiz not found for id: " + aLong));
        QuestionOfQuiz questionOfQuiz = modelMapper.map(questionOfQuizDto, QuestionOfQuiz.class);
        checkIfExist(questionOfQuizDto);
        Question question = questionRepository.findById(questionOfQuizDto.getQuestion_id()).orElseThrow(() -> new NotFoundEx("Question not found for id: " + questionOfQuizDto.getQuestion_id()));
        Quiz quiz = quizRepository.findById(questionOfQuizDto.getQuiz_id()).orElseThrow(() -> new NotFoundEx("Quiz not found for id: " + questionOfQuizDto.getQuiz_id()));
        questionOfQuiz.setQuestion(question);
        questionOfQuiz.setQuiz(quiz);
        questionOfQuiz.setId(aLong);
        questionOfQuiz = questionOfQuizRepository.save(questionOfQuiz);
        return modelMapper.map(questionOfQuiz, QuestionOfQuizDtoRsp.class);
    }

    @Override
    public Boolean delete(Long aLong) {
        QuestionOfQuiz optionalQuestionOfQuiz = questionOfQuizRepository.findById(aLong).orElseThrow(() -> new NotFoundEx("QuestionOfQuiz not found for id: " + aLong));
        questionOfQuizRepository.deleteById(aLong);
        return questionOfQuizRepository.findById(aLong).isEmpty();
    }

    @Override
    public QuestionOfQuizDtoRsp findOne(Long aLong) {
        QuestionOfQuiz questionOfQuiz = questionOfQuizRepository.findById(aLong).orElseThrow(() -> new NotFoundEx("QuestionOfQuiz not found for id: " + aLong));
        return modelMapper.map(questionOfQuiz, QuestionOfQuizDtoRsp.class);
    }

    @Override
    public List<QuestionOfQuizDtoRsp> findAll() {
        List<QuestionOfQuiz> questionOfQuizList = questionOfQuizRepository.findAll();
        return questionOfQuizList.stream().map(questionOfQuiz -> modelMapper.map(questionOfQuiz, QuestionOfQuizDtoRsp.class)).toList();
    }

    @Override
    public void checkIfExist(QuestionOfQuizDto questionOfQuizDto) {
        Optional<QuestionOfQuiz> optionalQuestionOfQuiz = questionOfQuizRepository.findByQuestionIdAndQuizId(questionOfQuizDto.getQuestion_id(), questionOfQuizDto.getQuiz_id());
        if (optionalQuestionOfQuiz.isPresent()) {
            throw new NotFoundEx("QuestionOfQuiz already exist for questionId: " + questionOfQuizDto.getQuestion_id() + " and quizId: " + questionOfQuizDto.getQuiz_id());
        }
    }
}