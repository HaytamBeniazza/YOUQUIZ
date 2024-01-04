package com.wi.quiz.Controllers;

import com.wi.quiz.DTO.Level.LevelDto;
import com.wi.quiz.DTO.Level.LevelDtoRsp;
import com.wi.quiz.Services.Impl.LevelServiceImpl;
import com.wi.quiz.Services.Inter.LevelService;
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
@RequestMapping("/level")
@RequiredArgsConstructor
public class LevelController {

    private final LevelService levelService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody LevelDto level) {
        Map<String, Object> message = new HashMap<>();
        LevelDtoRsp levelDto = levelService.save(level);
        message.put("message", "Level created successfully");
        message.put("data", levelDto);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Map<String, Object> message = new HashMap<>();
        message.put("content", levelService.findAll());
        return ResponseEntity.ok(message);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LevelDtoRsp> findById(@PathVariable Long id) {
        return ResponseEntity.ok(levelService.findOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody LevelDto levelDto, @PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        LevelDtoRsp level = levelService.update(levelDto, id);
        message.put("message", "Level updated successfully");
        message.put("data", level);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        if (levelService.delete(id)) {
            message.put("message", "Level deleted successfully");
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("message", "Level not deleted");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }


}
