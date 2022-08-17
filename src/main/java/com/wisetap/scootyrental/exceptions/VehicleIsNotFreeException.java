package com.wisetap.scootyrental.exceptions;

public class VehicleIsNotFreeException extends Exception{
    public VehicleIsNotFreeException(String message){
        super(message);
    }
}
