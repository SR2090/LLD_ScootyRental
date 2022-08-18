package com.wisetap.scootyrental.exceptions;

public class InvalidBookingCrossedDeadline extends Exception{
    public InvalidBookingCrossedDeadline(String message) {
        super(message);
    }
}
