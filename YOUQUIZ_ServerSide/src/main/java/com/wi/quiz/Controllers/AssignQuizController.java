package com.wi.quiz.Controllers;

import com.wi.quiz.DTO.AssignQuiz.AssignQuizDto;
import com.wi.quiz.DTO.AssignQuiz.AssignQuizDtoRsp;
import com.wi.quiz.Services.Impl.AssignQuizServiceImpl;
import com.wi.quiz.Services.Inter.AssignQuizService;
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
@RequestMapping("/assignquiz")
@RequiredArgsConstructor
public class AssignQuizController {

    private final AssignQuizService assignQuizService;
    @PostMapping
    public ResponseEntity<?> save(@RequestBody AssignQuizDto assignQuiz) {
        Map<String, Object> message = new HashMap<>();
        AssignQuizDtoRsp assignQuizDto =  assignQuizService.save(assignQuiz);
        message.put("message", "Assign Quiz created successfully");
        message.put("data", assignQuizDto);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }
    @GetMapping("/score/{id}")
    public ResponseEntity<?> getScore(@PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        int score = assignQuizService.getScore(id);
        message.put("message", "Assign Quiz Score");
        message.put("data", score);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam(defaultValue = "0") int  page, @RequestParam(defaultValue = "10") int  size) {
        Map<String, Object> message = new HashMap<>();
        message.put("content", assignQuizService.findAll());
        return ResponseEntity.ok(message);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssignQuizDtoRsp> findById(@PathVariable Long id) {
        return ResponseEntity.ok(assignQuizService.findOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody AssignQuizDto assignQuizDto, @PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        AssignQuizDtoRsp assignQuiz = assignQuizService.update(assignQuizDto, id);
        message.put("message", "Assign Quiz updated successfully");
        message.put("data", assignQuiz);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        if (assignQuizService.delete(id)) {
            message.put("message", "Assign Quiz deleted successfully");
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("message", "Assign Quiz not deleted");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/schema")
    public AssignQuizDto getSchema() {
        return new AssignQuizDto();
    }
}
