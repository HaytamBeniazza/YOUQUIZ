package com.wi.quiz.Controllers;

import com.wi.quiz.DTO.Subject.SubjectDtoRsp;
import com.wi.quiz.DTO.Subject.SubjectDto;
import com.wi.quiz.Services.Impl.SubjectServiceImpl;
import com.wi.quiz.Services.Inter.SubjectService;
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
@RequestMapping("/subject")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody SubjectDto subjectDto) {
        Map<String, Object> message = new HashMap<>();
        SubjectDtoRsp subject = subjectService.save(subjectDto);
        message.put("message", "Subject created successfully");
        message.put("data", subject);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam(defaultValue = "0") int  page, @RequestParam(defaultValue = "10") int  size) {
        Map<String, Object> message = new HashMap<>();
        message.put("content", subjectService.findAll());
        return ResponseEntity.ok(message);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectDtoRsp> findById(@PathVariable Long id) {
        return ResponseEntity.ok(subjectService.findOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody SubjectDto subjectDto, @PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        SubjectDtoRsp subject = subjectService.update(subjectDto, id);
        message.put("message", "Subject updated successfully");
        message.put("data", subject);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        if (subjectService.delete(id)){
            message.put("message", "Subject deleted successfully");
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("message", "Subject not deleted");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }
}
