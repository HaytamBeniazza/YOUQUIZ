package com.wi.quiz.DTO.Room;

import com.wi.quiz.Entities.Message;
import com.wi.quiz.Entities.Person;
import com.wi.quiz.Entities.RoomMembers;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomDto {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Long owner_id;
}
