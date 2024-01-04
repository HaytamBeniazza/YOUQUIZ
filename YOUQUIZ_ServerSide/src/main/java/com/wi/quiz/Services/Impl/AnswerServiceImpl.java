package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.Answer.AnswerDto;
import com.wi.quiz.DTO.Answer.AnswerDtoRsp;
import com.wi.quiz.Entities.Answer;
import com.wi.quiz.Entities.AssignQuiz;
import com.wi.quiz.Entities.Validation;
import com.wi.quiz.Exceptions.NotFoundEx;
import com.wi.quiz.Repositories.AnswerRepository;
import com.wi.quiz.Repositories.AssignQuizRepository;
import com.wi.quiz.Repositories.ValidationRepository;
import com.wi.quiz.Services.Inter.AnswerService;

import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {
    
    private final AnswerRepository answerRepository;

    
    private final AssignQuizRepository assignQuizRepository;

    private  final ValidationRepository validationRepository;

    
    private final ModelMapper modelMapper;

    @Override
    public AnswerDtoRsp save(AnswerDto answerDto) {
        AssignQuiz assignQuiz = assignQuizRepository.findById(answerDto.getAssignQuiz_id()).orElseThrow(() -> new NotFoundEx("AssignQuiz not found for id: " + answerDto.getAssignQuiz_id()));
        Validation validation = validationRepository.findById(answerDto.getValidation_id()).orElseThrow(() -> new NotFoundEx("Validation not found for id: " + answerDto.getValidation_id()));
        Answer answer = new Answer();
        answer.setAssignQuiz(assignQuiz);
        answer.setValidation(validation);
        answer = answerRepository.save(answer);
        return modelMapper.map(answer, AnswerDtoRsp.class);
    }

    @Override
    public AnswerDtoRsp update(AnswerDto answerDto, Long aLong) {
        answerRepository.findById(aLong).orElseThrow(() -> new NotFoundEx("Answer not found for id: " + aLong));
        AssignQuiz assignQuiz = assignQuizRepository.findById(answerDto.getAssignQuiz_id()).orElseThrow(() -> new NotFoundEx("AssignQuiz not found for id: " + answerDto.getAssignQuiz_id()));
        Validation validation = validationRepository.findById(answerDto.getValidation_id()).orElseThrow(() -> new NotFoundEx("Validation not found for id: " + answerDto.getValidation_id()));
        Answer answer = new Answer();
        answer.setAssignQuiz(assignQuiz);
        answer.setValidation(validation);
        answer = answerRepository.save(answer);
        return modelMapper.map(answer, AnswerDtoRsp.class);
    }

    @Override
    public Boolean delete(Long aLong) {
        Optional<Answer> optionalAnswer = answerRepository.findById(aLong);
        if (optionalAnswer.isEmpty()) {
            throw new NotFoundEx("Answer not found for id: " + aLong);
        }
        answerRepository.deleteById(aLong);
        return answerRepository.findById(aLong).isEmpty();
    }

    @Override
    public AnswerDtoRsp findOne(Long aLong) {
        Optional<Answer> optionalAnswer = answerRepository.findById(aLong);
        if (optionalAnswer.isEmpty()) {
            throw new NotFoundEx("Answer not found for id: " + aLong);
        }
        Answer answer = optionalAnswer.get();
        return modelMapper.map(answer, AnswerDtoRsp.class);
    }

    @Override
    public List<AnswerDtoRsp> findAll() {
        List<Answer> answers = answerRepository.findAll();
        return answers.stream().map(answer -> modelMapper.map(answer, AnswerDtoRsp.class)).toList();
    }

    @Override
    public List<AnswerDto> save(List<AnswerDto> answers) {
        List<Answer> answerList = answers.stream().map(answerDto -> {
            AssignQuiz assignQuiz = assignQuizRepository.findById(answerDto.getAssignQuiz_id()).orElseThrow(() -> new NotFoundEx("AssignQuiz not found for id: " + answerDto.getAssignQuiz_id()));
            Validation validation = validationRepository.findById(answerDto.getValidation_id()).orElseThrow(() -> new NotFoundEx("Validation not found for id: " + answerDto.getValidation_id()));
            if (!assignQuiz.isPlayed()) {
                assignQuiz.setPlayed(true);
                assignQuizRepository.save(assignQuiz);
            }
            Answer answer = modelMapper.map(answerDto, Answer.class);
            answer.setAssignQuiz(assignQuiz);
            answer.setValidation(validation);
            return answer;
        }).toList();
        answerList = answerRepository.saveAll(answerList);
        return answerList.stream().map(answer -> modelMapper.map(answer, AnswerDto.class)).toList();
    }
}
