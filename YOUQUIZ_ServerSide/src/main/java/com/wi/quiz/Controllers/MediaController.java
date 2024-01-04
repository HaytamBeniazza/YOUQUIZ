package com.wi.quiz.Controllers;

import com.wi.quiz.DTO.Media.MediaDto;
import com.wi.quiz.DTO.Media.MediaDtoRsp;
import com.wi.quiz.Services.Impl.MediaServiceImpl;
import com.wi.quiz.Services.Inter.MediaService;
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
@RequestMapping("/media")
@RequiredArgsConstructor
public class MediaController {

    private final MediaService mediaService;
    @PostMapping
    public ResponseEntity<?> save(@RequestBody MediaDto media) {
        Map<String, Object> message = new HashMap<>();
        MediaDtoRsp mediaDto =  mediaService.save(media);
        message.put("message", "Media created successfully");
        message.put("data", mediaDto);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam(defaultValue = "0") int  page, @RequestParam(defaultValue = "10") int  size) {
        Map<String, Object> message = new HashMap<>();
        message.put("content", mediaService.findAll());
        return ResponseEntity.ok(message);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MediaDtoRsp> findById(@PathVariable Long id) {
        return ResponseEntity.ok(mediaService.findOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody MediaDto mediaDto, @PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        MediaDtoRsp media = mediaService.update(mediaDto, id);
        message.put("message", "Media updated successfully");
        message.put("data", media);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        if (mediaService.delete(id)) {
            message.put("message", "Media deleted successfully");
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("message", "Media not deleted");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }
}
