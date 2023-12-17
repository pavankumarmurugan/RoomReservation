package com.example.roomreservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.roomreservation.entity.ReservationEntity;
import com.example.roomreservation.service.RoomReservationService;

@RestController
@RequestMapping("/api/reservations")
public class RoomReservationController {

 @Autowired
 private RoomReservationService reservationService;

 @GetMapping("/all")
 public List<ReservationEntity> getAllReservations() {
     return reservationService.getAllReservations();
 }

 @GetMapping("/list/{roomName}")
 public List<ReservationEntity> getReservationsForRoom(@PathVariable String roomName) {
     return reservationService.getReservationsForRoom(roomName);
 }

 @GetMapping("/details/{reservationDate}/{reservationTime}")
 public List<ReservationEntity> getReservationsForDateAndTime(
         @PathVariable String reservationDate,
         @PathVariable String reservationTime) {
     return reservationService.getReservationsForDateAndTime(reservationDate, reservationTime);
 }

 @PostMapping("/add")
 public String addReservation(@RequestBody ReservationEntity reservation) {
     reservationService.addReservation(reservation);
     return "Reservation added successfully!";
 }

 @PutMapping("/update/{id}")
 public String updateReservation(
         @PathVariable Long id,
         @RequestBody ReservationEntity updatedReservation) {
     reservationService.updateReservation(id, updatedReservation);
     return "Reservation updated successfully!";
 }

 @DeleteMapping("/delete/{id}")
 public String deleteReservation(@PathVariable Long id) {
     reservationService.deleteReservation(id);
     return "Reservation deleted successfully!";
 }
}

