package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.Question.QuestionDto;
import com.wi.quiz.DTO.Question.QuestionDtoRsp;
import com.wi.quiz.Entities.Level;
import com.wi.quiz.Entities.Question;
import com.wi.quiz.Entities.Subject;
import com.wi.quiz.Exceptions.NotFoundEx;
import com.wi.quiz.Repositories.LevelRepository;
import com.wi.quiz.Repositories.QuestionRepository;
import com.wi.quiz.Repositories.SubjectRepository;
import com.wi.quiz.Services.Inter.QuestionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    
    private final QuestionRepository questionRepository;
    private final LevelRepository levelRepository;
    private final SubjectRepository subjectRepository;

    
    private final ModelMapper modelMapper;

    @Override
    public QuestionDtoRsp save(QuestionDto questionDto) {
            Question question = modelMapper.map(questionDto, Question.class);
        Level level = levelRepository.findById(questionDto.getLevel_id()).orElseThrow(() -> new NotFoundEx("Level not found for id: " + questionDto.getLevel_id()));
        Subject subject = subjectRepository.findById(questionDto.getSubject_id()).orElseThrow(() -> new NotFoundEx("Subject not found for id: " + questionDto.getSubject_id()));
        question.setLevel(level);
        question.setSubject(subject);
        question = questionRepository.save(question);
        return modelMapper.map(question, QuestionDtoRsp.class);
    }

    @Override
    public QuestionDtoRsp update(QuestionDto questionDto, Long aLong) {
        questionRepository.findById(aLong).orElseThrow(() -> new NotFoundEx("Question not found for id: " + aLong));
        Question question = modelMapper.map(questionDto, Question.class);
        Level level = levelRepository.findById(questionDto.getLevel_id()).orElseThrow(() -> new NotFoundEx("Level not found for id: " + questionDto.getLevel_id()));
        Subject subject = subjectRepository.findById(questionDto.getSubject_id()).orElseThrow(() -> new NotFoundEx("Subject not found for id: " + questionDto.getSubject_id()));
        question.setLevel(level);
        question.setSubject(subject);
        question.setId(aLong);
        question = questionRepository.save(question);
        return modelMapper.map(question, QuestionDtoRsp.class);
        
    }

    @Override
    public Boolean delete(Long aLong) {
        
            Optional<Question> question = questionRepository.findById(aLong);
            if (question.isPresent()) {
                questionRepository.deleteById(aLong);
                return questionRepository.findById(aLong).isEmpty();
            } else {
                throw new NotFoundEx("Question not found for id: " + aLong);
            }
        
    }

    @Override
    public QuestionDtoRsp findOne(Long aLong) {
        
            Optional<Question> optionalQuestion = questionRepository.findById(aLong);
            if (optionalQuestion.isPresent()) {
                return modelMapper.map(optionalQuestion.get(), QuestionDtoRsp.class);
            } else {
                throw new NotFoundEx("Question not found for id: " + aLong);
            }
        
    }

    @Override
    public List<QuestionDtoRsp> findAll() {
            List<Question> questions = questionRepository.findAll();
            return questions.stream().map(question -> modelMapper.map(question, QuestionDtoRsp.class)).toList();
    }
}
