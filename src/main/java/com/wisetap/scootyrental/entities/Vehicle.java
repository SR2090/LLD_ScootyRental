package com.wisetap.scootyrental.entities;

public interface Vehicle {
   
    // ublock a vehicle to end trip
    public void setVehicleStatus(VehicleStatus stateOfVehicle);

    // block a vehicle for registration (register for trip)
    public VehicleStatus getVehicleStatus();
    
    public String getVehicleRegistration();

    public String getVehicleName();

    public Outlet getOutletDetais();
    
}
