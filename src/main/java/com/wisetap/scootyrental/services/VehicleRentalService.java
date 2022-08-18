package com.wisetap.scootyrental.services;

import com.wisetap.scootyrental.entities.User;
import com.wisetap.scootyrental.exceptions.OutletFullException;
import com.wisetap.scootyrental.exceptions.VehicleDoesNotExistException;
import com.wisetap.scootyrental.exceptions.VehicleIsNotFreeException;

public interface VehicleRentalService {
    public void listNearestOutletsAndTheirAvailableVehicles(User user);
    public void bookAVehicle(User user, String vehicleRegistrationDetails)  throws VehicleDoesNotExistException;
    public void endTripWithVehicle(User user, String vehicleRegistrationDetails)  throws VehicleIsNotFreeException, OutletFullException ;
}
