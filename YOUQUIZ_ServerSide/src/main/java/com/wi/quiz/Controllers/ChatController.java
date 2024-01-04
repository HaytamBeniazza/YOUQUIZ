package com.wi.quiz.Controllers;

import com.wi.quiz.DTO.Message.MessageDto;
import com.wi.quiz.DTO.Message.MessageDtoRsp;
import com.wi.quiz.DTO.Person.PersonDtoLogin;
import com.wi.quiz.Entities.Person;
import com.wi.quiz.Services.Impl.PersonServiceImpl;
import com.wi.quiz.Services.Inter.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class ChatController {
    private final MessageService messageService;
    private  final PersonServiceImpl personService;


    @MessageMapping("/chat/{roomId}")
    @SendTo("/topic/{roomId}")
    public MessageDtoRsp chat(@DestinationVariable String roomId, MessageDto message) {
        return messageService.save(message);
    }

    @MessageMapping("/login")
    @SendTo("/topic/login")
    public ResponseEntity<?> login(PersonDtoLogin dtoLogin) {
        Map<String, Object> message = new HashMap<>();
        Optional<PersonDtoLogin> person = personService.login(dtoLogin);
        message.put("login", person.isPresent());
        message.put("content", person.orElse(null));
        return ResponseEntity.ok(message);
    }
}