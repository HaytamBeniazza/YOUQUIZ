package com.wi.quiz.Repositories;

import com.wi.quiz.Entities.Response;
import com.wi.quiz.Entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
