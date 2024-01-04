package com.wi.quiz.Controllers;

import com.wi.quiz.DTO.Question.QuestionDto;
import com.wi.quiz.DTO.Question.QuestionDtoRsp;
import com.wi.quiz.Services.Impl.QuestionServiceImpl;
import com.wi.quiz.Services.Inter.QuestionService;
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
@RequestMapping("/question")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody QuestionDto question) {
        Map<String, Object> message = new HashMap<>();
        message.put("message", "Question created successfully");
        QuestionDtoRsp questionDto = questionService.save(question);
        message.put("data", questionDto);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam(defaultValue = "0") int  page, @RequestParam(defaultValue = "10") int  size) {
        Map<String, Object> message = new HashMap<>();
        message.put("content", questionService.findAll());
        return ResponseEntity.ok(message);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionDtoRsp> findById(@PathVariable Long id) {
        return ResponseEntity.ok(questionService.findOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody QuestionDto question, @PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        QuestionDtoRsp questionDto = questionService.update(question, id);
        message.put("message", "Question updated successfully");
        message.put("data", questionDto);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        if (questionService.delete(id)){
            message.put("message", "Question deleted successfully");
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("message", "Question not deleted");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }
}
