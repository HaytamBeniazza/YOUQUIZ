package com.wi.quiz.Repositories;

import com.wi.quiz.Entities.RoomMembers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomMembersRepository  extends JpaRepository<RoomMembers, Long> {
}
