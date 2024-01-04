package com.wi.quiz.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private Person owner;
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<RoomMembers> members;
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Message> messages;
}
