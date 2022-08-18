package com.wisetap.scootyrental.entities;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.wisetap.scootyrental.exceptions.InvalidBookingCrossedDeadline;

public class Reservation {
    private User user;
    private ReservationStatus status;
    private Vehicle vehicle;
    private LocalDateTime registrationTime;

    // x minutes after which the registration if not accepted becomes invalid.
    private static final Integer deadline = 90;

    public Reservation(User user, ReservationStatus status, Vehicle vehicle){
        this.user = user;
        this.status = status;
        this.vehicle = vehicle;
        this.registrationTime = LocalDateTime.now();
    }

    public ReservationStatus getStatus(){
        return this.status;
    }

    public boolean isTheBookingValid(LocalDateTime pickUpTime){
        long minutes = ChronoUnit.MINUTES.between(registrationTime, pickUpTime);
        return Math.abs(minutes) > deadline ? true : false;
    }

    public void vehicleHasBeenBooked() throws InvalidBookingCrossedDeadline{
        if(!isTheBookingValid(LocalDateTime.now())){
            vehicle.setVehicleStatus(VehicleStatus.NOTPICKED);
            throw new InvalidBookingCrossedDeadline(deadline + " minutes has been crossed");
        } 
        vehicle.setVehicleStatus(VehicleStatus.BOOKED);
    }

    public void hasRequestedDropOff() {
        System.out.println("Please reach out to user at " + user.getdetails());
    }

    public User getRegisteredUser(){
        return user;
    }
}
