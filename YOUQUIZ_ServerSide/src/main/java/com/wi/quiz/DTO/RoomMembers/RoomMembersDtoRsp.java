package com.wi.quiz.DTO.RoomMembers;

import com.wi.quiz.DTO.Room.RoomDto;
import com.wi.quiz.Entities.Person;
import com.wi.quiz.Entities.Room;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomMembersDtoRsp {
    private Long id;
    private Person member;
    private RoomDto room;
}
