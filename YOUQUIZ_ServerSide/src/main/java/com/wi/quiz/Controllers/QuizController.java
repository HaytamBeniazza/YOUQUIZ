package com.wi.quiz.Controllers;

import com.wi.quiz.DTO.Quiz.QuizDto;
import com.wi.quiz.DTO.Quiz.QuizDtoRsp;
import com.wi.quiz.Services.Impl.QuizServiceImpl;
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
@RequestMapping("/quiz")
@RequiredArgsConstructor
public class QuizController {

    private final QuizServiceImpl quizService;
    @PostMapping
    public ResponseEntity<?> save(@RequestBody QuizDto quiz) {
        Map<String, Object> message = new HashMap<>();
        QuizDtoRsp quizDto = quizService.save(quiz);
        message.put("message", "Quiz created successfully");
        message.put("data", quizDto);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam(defaultValue = "0") int  page, @RequestParam(defaultValue = "10") int  size) {
        Map<String, Object> message = new HashMap<>();
        message.put("content", quizService.findAll());
        return ResponseEntity.ok(message);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizDtoRsp> findById(@PathVariable Long id) {
        return ResponseEntity.ok(quizService.findOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody QuizDto quiz, @PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        QuizDtoRsp quizDto = quizService.update(quiz, id);
        message.put("message", "Quiz updated successfully");
        message.put("data", quizDto);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        if (quizService.delete(id)){
            message.put("message", "Quiz deleted successfully");
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("message", "Quiz not deleted");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/schema")
    public QuizDto getSchema() {
        return new QuizDto();
    }
}
