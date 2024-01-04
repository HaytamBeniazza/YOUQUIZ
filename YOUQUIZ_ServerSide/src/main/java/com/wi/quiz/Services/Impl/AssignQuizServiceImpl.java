package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.AssignQuiz.AssignQuizDto;
import com.wi.quiz.DTO.AssignQuiz.AssignQuizDtoRsp;
import com.wi.quiz.Entities.Answer;
import com.wi.quiz.Entities.AssignQuiz;
import com.wi.quiz.Entities.Quiz;
import com.wi.quiz.Entities.Student;
import com.wi.quiz.Exceptions.NotFoundEx;
import com.wi.quiz.Repositories.AssignQuizRepository;
import com.wi.quiz.Repositories.QuizRepository;
import com.wi.quiz.Repositories.StudentRepository;
import com.wi.quiz.Services.Inter.AssignQuizService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssignQuizServiceImpl implements AssignQuizService {

    private final AssignQuizRepository assignQuizRepository;
    private final QuizRepository quizRepository;
    private final StudentRepository studentRepository;


    private final ModelMapper modelMapper;

    @Override
    public AssignQuizDtoRsp save(AssignQuizDto assignQuizDto) {
        Quiz quiz = quizRepository.findById(assignQuizDto.getQuiz_id()).orElseThrow(() -> new NotFoundEx("Quiz not found for id: " + assignQuizDto.getQuiz_id()));
        assignQuizRepository.findFirstByQuizIdOrderByChanceDesc(quiz.getId()).ifPresent(assignQuiz1 -> {
            assignQuizDto.setChance(assignQuiz1.getChance() + 1);
        });
        if (assignQuizDto.getChance() > quiz.getNumberOfChances()) {
            throw new NotFoundEx("You have reached the maximum number of chances for this quiz");
        }
        Student student = studentRepository.findById(assignQuizDto.getStudent_id()).orElseThrow(() -> new NotFoundEx("Student not found for id: " + assignQuizDto.getStudent_id()));
        AssignQuiz assignQuiz = modelMapper.map(assignQuizDto, AssignQuiz.class);
        assignQuiz.setQuiz(quiz);
        assignQuiz.setStudent(student);
        assignQuizRepository.findByStudentIdAndQuizId(student.getId(), quiz.getId()).ifPresent(assignQuiz1 -> {
            throw new NotFoundEx("AssignQuiz already exists for student: " + student.getId() + " and quiz: " + quiz.getId());
        });
        assignQuiz = assignQuizRepository.save(assignQuiz);
        return modelMapper.map(assignQuiz, AssignQuizDtoRsp.class);
    }

    @Override
    public AssignQuizDtoRsp update(AssignQuizDto assignQuizDto, Long aLong) {
        assignQuizRepository.findById(aLong).orElseThrow(() -> new NotFoundEx("AssignQuiz not found for id: " + aLong));
        Quiz quiz = quizRepository.findById(assignQuizDto.getQuiz_id()).orElseThrow(() -> new NotFoundEx("Quiz not found for id: " + assignQuizDto.getQuiz_id()));
        Student student = studentRepository.findById(assignQuizDto.getStudent_id()).orElseThrow(() -> new NotFoundEx("Student not found for id: " + assignQuizDto.getStudent_id()));
        AssignQuiz assignQuiz = modelMapper.map(assignQuizDto, AssignQuiz.class);
        assignQuiz.setQuiz(quiz);
        assignQuiz.setStudent(student);
        assignQuiz.setId(aLong);
        assignQuiz = assignQuizRepository.save(assignQuiz);
        return modelMapper.map(assignQuiz, AssignQuizDtoRsp.class);
    }

    @Override
    public Boolean delete(Long aLong) {
        Optional<AssignQuiz> optionalAssignQuiz = assignQuizRepository.findById(aLong);
        if (optionalAssignQuiz.isEmpty()) {
            throw new NotFoundEx("AssignQuiz not found for id: " + aLong);
        }
        assignQuizRepository.deleteById(aLong);
        return assignQuizRepository.findById(aLong).isEmpty();
    }

    @Override
    public AssignQuizDtoRsp findOne(Long aLong) {
        Optional<AssignQuiz> optionalAssignQuiz = assignQuizRepository.findById(aLong);
        if (optionalAssignQuiz.isEmpty()) {
            throw new NotFoundEx("AssignQuiz not found for id: " + aLong);
        }
        AssignQuiz assignQuiz = optionalAssignQuiz.get();
        return modelMapper.map(assignQuiz, AssignQuizDtoRsp.class);
    }

    @Override
    public List<AssignQuizDtoRsp> findAll() {
        List<AssignQuiz> assignQuizList = assignQuizRepository.findAll();
        return assignQuizList.stream()
                .map(assignQuiz -> modelMapper.map(assignQuiz, AssignQuizDtoRsp.class))
                .toList();
    }

    @Override
    public int getScore(Long id) {
        Optional<AssignQuiz> optionalAssignQuiz = assignQuizRepository.findById(id);
        if (optionalAssignQuiz.isEmpty()) {
            throw new NotFoundEx("AssignQuiz not found for id: " + id);
        }
        AssignQuiz assignQuiz = optionalAssignQuiz.get();
        int score = 0;
        for (Answer answer : assignQuiz.getAnswers()) {
            if (answer.getValidation().isCorrect()) {
                score = score + answer.getValidation().getPoints();
            }
        }
        return score;
    }
}
