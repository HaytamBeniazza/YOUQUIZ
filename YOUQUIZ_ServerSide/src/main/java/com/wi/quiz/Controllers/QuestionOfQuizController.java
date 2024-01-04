package com.wi.quiz.Controllers;

import com.wi.quiz.DTO.QuestionOfQuiz.QuestionOfQuizDto;
import com.wi.quiz.DTO.QuestionOfQuiz.QuestionOfQuizDtoRsp;
import com.wi.quiz.Services.Impl.QuestionOfQuizServiceImpl;
import com.wi.quiz.Services.Inter.QuestionOfQuizService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/questionofquiz")
@RequiredArgsConstructor
public class QuestionOfQuizController {

    private final QuestionOfQuizService questionOfQuizService;
    @PostMapping
    public ResponseEntity<?> save(@RequestBody QuestionOfQuizDto questionOfQuiz) {
        Map<String, Object> message = new HashMap<>();
        QuestionOfQuizDtoRsp questionOfQuizDto =  questionOfQuizService.save(questionOfQuiz);
        message.put("message", "Question of Quiz created successfully");
        message.put("data", questionOfQuizDto);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam(defaultValue = "0") int  page, @RequestParam(defaultValue = "10") int  size) {
        Map<String, Object> message = new HashMap<>();
        message.put("content", questionOfQuizService.findAll());
        return ResponseEntity.ok(message);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionOfQuizDtoRsp> findById(@PathVariable Long id) {
        return ResponseEntity.ok(questionOfQuizService.findOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody QuestionOfQuizDto questionOfQuizDto, @PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        QuestionOfQuizDtoRsp questionOfQuiz = questionOfQuizService.update(questionOfQuizDto, id);
        message.put("message", "Question of Quiz updated successfully");
        message.put("data", questionOfQuiz);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        if (questionOfQuizService.delete(id)) {
            message.put("message", "Question of Quiz deleted successfully");
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("message", "Question of Quiz not deleted");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/test")
    public QuestionOfQuizDto test() {
        return new QuestionOfQuizDto();
    }
}
