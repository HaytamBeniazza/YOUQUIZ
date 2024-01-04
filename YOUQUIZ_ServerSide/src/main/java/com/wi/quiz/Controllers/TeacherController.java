package com.wi.quiz.Controllers;

import com.wi.quiz.DTO.Teacher.TeacherDto;
import com.wi.quiz.DTO.Teacher.TeacherDtoRsp;
import com.wi.quiz.Entities.Teacher;
import com.wi.quiz.Services.Impl.TeacherServiceImpl;
import com.wi.quiz.Services.Inter.TeacherService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;
    @PostMapping
    public ResponseEntity<?> save(@RequestBody TeacherDto teacher) {
        Map<String, Object> message = new HashMap<>();
        TeacherDtoRsp teacherDto =  teacherService.save(teacher);
        message.put("message", "Teacher created successfully");
        message.put("data", teacherDto);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam(defaultValue = "0") int  page, @RequestParam(defaultValue = "10") int  size) {
        Map<String, Object> message = new HashMap<>();
        message.put("content", teacherService.findAll());
        return ResponseEntity.ok(message);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDtoRsp> findById(@PathVariable Long id) {
        return ResponseEntity.ok(teacherService.findOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody TeacherDto teacherDto, @PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        TeacherDtoRsp teacher = teacherService.update(teacherDto, id);
        message.put("message", "Teacher updated successfully");
        message.put("data", teacher);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        if (teacherService.delete(id)) {
            message.put("message", "Teacher deleted successfully");
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("message", "Teacher not deleted");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/test")
    public Teacher huuh() {
        Teacher student = new Teacher();
        student.setDateOfBirth(LocalDate.now());
        return student;
    }
}
