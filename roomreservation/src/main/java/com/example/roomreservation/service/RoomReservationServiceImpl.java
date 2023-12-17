package com.example.roomreservation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.roomreservation.entity.ReservationEntity;
import com.example.roomreservation.repository.RoomReservationRepository;

@Service
public class RoomReservationServiceImpl implements RoomReservationService
{
	@Autowired
	RoomReservationRepository reservationRepository;

	 public List<ReservationEntity> getAllReservations() {
	     return reservationRepository.findAll();
	 }

	 public List<ReservationEntity> getReservationsForRoom(String roomName) {
	     return reservationRepository.findByRoomName(roomName);
	 }

	 public List<ReservationEntity> getReservationsForDateAndTime(String reservationDate, String reservationTime) {
	     return reservationRepository.findByReservationDateAndReservationTime(reservationDate, reservationTime);
	 }

	 public void addReservation(ReservationEntity reservation) {
	     reservationRepository.save(reservation);
	 }

	 public void updateReservation(Long reservationId, ReservationEntity updatedReservation) {
	     Optional<ReservationEntity> optionalReservation = reservationRepository.findById(reservationId);

	     if (optionalReservation.isPresent()) {
	    	 ReservationEntity reservation = optionalReservation.get();
	         reservation.setStudentName(updatedReservation.getStudentName());
	         reservation.setRoomName(updatedReservation.getRoomName());
	         reservation.setReservationDate(updatedReservation.getReservationDate());
	         reservation.setReservationTime(updatedReservation.getReservationTime());
	         reservation.setOccupancy(updatedReservation.getOccupancy());
	         reservationRepository.save(reservation);
	     } else {
	         throw new RuntimeException("Reservation not found with id: " + reservationId);
	     }
	 }

	 public void deleteReservation(Long reservationId) {
	     reservationRepository.deleteById(reservationId);
	 }

}
