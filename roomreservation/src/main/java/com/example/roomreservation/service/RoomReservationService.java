package com.example.roomreservation.service;

import java.util.List;

import com.example.roomreservation.entity.ReservationEntity;

public interface RoomReservationService {
	
	public List<ReservationEntity> getAllReservations();
	
	public List<ReservationEntity> getReservationsForRoom(String roomName);
	
	public List<ReservationEntity> getReservationsForDateAndTime(String reservationDate, String reservationTime);
	
	public void addReservation(ReservationEntity reservation);
	
	public void updateReservation(Long reservationId, ReservationEntity updatedReservation);
	
	public void deleteReservation(Long reservationId);
}

