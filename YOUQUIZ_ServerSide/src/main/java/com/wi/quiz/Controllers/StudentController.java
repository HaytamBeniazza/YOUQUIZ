package com.wi.quiz.Controllers;

import com.wi.quiz.DTO.Student.StudentDto;
import com.wi.quiz.DTO.Student.StudentDtoRsp;
import com.wi.quiz.Services.Impl.StudentServiceImpl;
import com.wi.quiz.Services.Inter.StudentService;
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
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody StudentDto student) {
        Map<String, Object> message = new HashMap<>();
        StudentDtoRsp studentDto =  studentService.save(student);
        message.put("message", "Student created successfully");
        message.put("data", studentDto);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam(defaultValue = "0") int  page, @RequestParam(defaultValue = "10") int  size) {
        Map<String, Object> message = new HashMap<>();
        message.put("content", studentService.findAll());
        return ResponseEntity.ok(message);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDtoRsp> findById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.findOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody StudentDto studentDto, @PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        StudentDtoRsp student = studentService.update(studentDto, id);
        message.put("message", "Student updated successfully");
        message.put("data", student);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        if (studentService.delete(id)) {
            message.put("message", "Student deleted successfully");
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("message", "Student not deleted");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

}
