package com.wi.quiz.Controllers;

import com.wi.quiz.DTO.Room.RoomDto;
import com.wi.quiz.DTO.Room.RoomDtoRsp;
import com.wi.quiz.DTO.Response.ResponseDto;
import com.wi.quiz.DTO.Response.ResponseDtoRsp;
import com.wi.quiz.Services.Inter.RoomService;
import com.wi.quiz.Services.Inter.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("/room")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody RoomDto room) {
        Map<String, Object> message = new HashMap<>();
        RoomDtoRsp roomDto = roomService.save(room);
        message.put("message", "Room created successfully");
        message.put("data", roomDto);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Map<String, Object> message = new HashMap<>();
        message.put("content", roomService.findAll());
        return ResponseEntity.ok(message);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomDtoRsp> findById(@PathVariable Long id) {
        return ResponseEntity.ok(roomService.findOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody RoomDto roomDto, @PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        RoomDtoRsp room = roomService.update(roomDto, id);
        message.put("message", "Room updated successfully");
        message.put("data", room);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        if (roomService.delete(id)) {
            message.put("message", "Room deleted successfully");
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("message", "Room not deleted");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }
}
