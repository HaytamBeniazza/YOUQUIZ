package com.wi.quiz.DTO.RoomMembers;

import com.wi.quiz.Entities.Person;
import com.wi.quiz.Entities.Room;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomMembersDtoForRoom {
    private Long id;
    private Person member;
}
