package com.wi.quiz.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity(name="Message")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MESSAGES")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String content;
    @ManyToOne
    private Room room;
    @ManyToOne
    private Person sender;
    private LocalTime time;
}
