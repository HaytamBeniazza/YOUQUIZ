package com.wi.quiz.Controllers;

import com.wi.quiz.DTO.RoomMembers.RoomMembersDto;
import com.wi.quiz.DTO.RoomMembers.RoomMembersDtoRsp;
import com.wi.quiz.DTO.Response.ResponseDto;
import com.wi.quiz.DTO.Response.ResponseDtoRsp;
import com.wi.quiz.Services.Inter.RoomMembersService;
import com.wi.quiz.Services.Inter.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("/roomembers")
@RequiredArgsConstructor
public class RoomMembersController {
    private final RoomMembersService roomMembersService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody RoomMembersDto roomMembers) {
        Map<String, Object> message = new HashMap<>();
        RoomMembersDtoRsp roomMembersDto = roomMembersService.save(roomMembers);
        message.put("message", "RoomMembers created successfully");
        message.put("data", roomMembersDto);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Map<String, Object> message = new HashMap<>();
        message.put("content", roomMembersService.findAll());
        return ResponseEntity.ok(message);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomMembersDtoRsp> findById(@PathVariable Long id) {
        return ResponseEntity.ok(roomMembersService.findOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody RoomMembersDto roomMembersDto, @PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        RoomMembersDtoRsp roomMembers = roomMembersService.update(roomMembersDto, id);
        message.put("message", "RoomMembers updated successfully");
        message.put("data", roomMembers);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        if (roomMembersService.delete(id)) {
            message.put("message", "RoomMembers deleted successfully");
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("message", "RoomMembers not deleted");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }
}
