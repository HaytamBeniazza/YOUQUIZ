package com.wi.quiz.Controllers;

import com.wi.quiz.DTO.Message.MessageDto;
import com.wi.quiz.DTO.Message.MessageDtoRsp;
import com.wi.quiz.DTO.Response.ResponseDto;
import com.wi.quiz.DTO.Response.ResponseDtoRsp;
import com.wi.quiz.Services.Inter.MessageService;
import com.wi.quiz.Services.Inter.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody MessageDto message) {
        Map<String, Object> messageResponseHashMap = new HashMap<>();
        MessageDtoRsp messageDto = messageService.save(message);
        messageResponseHashMap.put("messageResponseHashMap", "Message created successfully");
        messageResponseHashMap.put("data", messageDto);
        return new ResponseEntity<>(messageResponseHashMap, HttpStatus.CREATED);
    }

    @GetMapping("/room/{id}")
    public ResponseEntity<?> findAll(@PathVariable Long id) {
        Map<String, Object> messageResponseHashMap = new HashMap<>();
        messageResponseHashMap.put("content", messageService.findAll(id));
        return ResponseEntity.ok(messageResponseHashMap);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageDtoRsp> findById(@PathVariable Long id) {
        return ResponseEntity.ok(messageService.findOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody MessageDto messageDto, @PathVariable Long id) {
        Map<String, Object> messageResponseHashMap = new HashMap<>();
        MessageDtoRsp message = messageService.update(messageDto, id);
        messageResponseHashMap.put("messageResponseHashMap", "Message updated successfully");
        messageResponseHashMap.put("data", message);
        return new ResponseEntity<>(messageResponseHashMap, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> messageResponseHashMap = new HashMap<>();
        if (messageService.delete(id)) {
            messageResponseHashMap.put("messageResponseHashMap", "Message deleted successfully");
            return new ResponseEntity<>(messageResponseHashMap, HttpStatus.OK);
        } else {
            messageResponseHashMap.put("messageResponseHashMap", "Message not deleted");
            return new ResponseEntity<>(messageResponseHashMap, HttpStatus.NOT_FOUND);
        }
    }
}
