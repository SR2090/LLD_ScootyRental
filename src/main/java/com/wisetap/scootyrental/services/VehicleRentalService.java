package com.wisetap.scootyrental.services;

import com.wisetap.scootyrental.entities.User;

public interface VehicleRentalService {
    public void rentASingleVehicleForTrip(User user);
    public void returnRentedVehicleAfterTrip(User user);
    public void viewNearByVehicleRentingOutletsForUser(User user);
    public void returnNearByOutletForParking();
}
