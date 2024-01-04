package com.wi.quiz.Controllers;

import com.wi.quiz.DTO.Answer.AnswerDto;
import com.wi.quiz.DTO.Answer.AnswerDtoRsp;
import com.wi.quiz.Services.Impl.AnswerServiceImpl;
import com.wi.quiz.Services.Inter.AnswerService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
@RequestMapping("/answer")
@RequiredArgsConstructor
public class AnswerController {
    private final AnswerService answerService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody List<AnswerDto> quiz) {
        Map<String, Object> message = new HashMap<>();
        List<AnswerDto> quizDto = answerService.save(quiz);
        message.put("message", "Answer created successfully");
        message.put("data", quizDto);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam(defaultValue = "0") int  page, @RequestParam(defaultValue = "10") int  size) {
        Map<String, Object> message = new HashMap<>();
        message.put("content", answerService.findAll());
        return ResponseEntity.ok(message);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnswerDtoRsp> findById(@PathVariable Long id) {
        return ResponseEntity.ok(answerService.findOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody AnswerDto quiz, @PathVariable Long id) {
        AnswerDtoRsp quizDto = answerService.update(quiz, id);
        Map<String, Object> message = new HashMap<>();
        message.put("message", "Answer updated successfully");
        message.put("data", quizDto);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        if (answerService.delete(id)){
            message.put("message", "Answer deleted successfully");
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("message", "Answer not deleted");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }
}
