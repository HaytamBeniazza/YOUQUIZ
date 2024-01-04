package com.wi.quiz.Controllers;

import com.wi.quiz.DTO.Response.ResponseDto;
import com.wi.quiz.DTO.Response.ResponseDtoRsp;
import com.wi.quiz.Services.Impl.ResponseServiceImpl;
import com.wi.quiz.Services.Inter.ResponseService;
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
@RequestMapping("/response")
@RequiredArgsConstructor
public class ResponseController {

    private final ResponseService responseService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ResponseDto response) {
        Map<String, Object> message = new HashMap<>();
        ResponseDtoRsp responseDto = responseService.save(response);
        message.put("message", "Response created successfully");
        message.put("data", responseDto);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam(defaultValue = "0") int  page, @RequestParam(defaultValue = "10") int  size) {
        Map<String, Object> message = new HashMap<>();
        message.put("content", responseService.findAll());
        return ResponseEntity.ok(message);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDtoRsp> findById(@PathVariable Long id) {
        return ResponseEntity.ok(responseService.findOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody ResponseDto response, @PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        ResponseDtoRsp responseDto = responseService.update(response, id);
        message.put("message", "Response updated successfully");
        message.put("data", responseDto);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        if (responseService.delete(id)){
            message.put("message", "Response deleted successfully");
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("message", "Response not deleted");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

}
