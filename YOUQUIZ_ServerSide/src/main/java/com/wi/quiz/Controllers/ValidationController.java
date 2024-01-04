package com.wi.quiz.Controllers;

import com.wi.quiz.DTO.Validation.ValidationDto;
import com.wi.quiz.DTO.Validation.ValidationDtoRsp;
import com.wi.quiz.Services.Inter.ValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/validation")
@RequiredArgsConstructor
public class ValidationController {

    private final ValidationService validationService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ValidationDto validation) {
        Map<String, Object> message = new HashMap<>();
        ValidationDtoRsp validationDtoRsp =  validationService.save(validation);
        message.put("message", "Validation created successfully");
        message.put("data", validationDtoRsp);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Map<String, Object> message = new HashMap<>();
        message.put("content", validationService.findAll());
        return ResponseEntity.ok(message);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ValidationDtoRsp> findById(@PathVariable Long id) {
        return ResponseEntity.ok(validationService.findOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody ValidationDto validationDto, @PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        ValidationDtoRsp validation = validationService.update(validationDto, id);
        message.put("message", "Validation updated successfully");
        message.put("data", validation);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        if (validationService.delete(id)) {
            message.put("message", "Validation deleted successfully");
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("message", "Validation not deleted");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }
}
