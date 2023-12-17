package com.example.roomreservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.roomreservation.entity.ReservationEntity;

@Repository
public interface RoomReservationRepository extends JpaRepository<ReservationEntity, Long> {
 List<ReservationEntity> findByRoomName(String roomName);

 List<ReservationEntity> findByReservationDateAndReservationTime(String reservationDate, String reservationTime);
}

