package com.wisetap.scootyrental.entities;

public class Scooty implements Vehicle{
    private String name;
    private String registration;
    private Outlet outletDetail;
    private VehicleStatus status;
    
    // any vehicle that is created will have the following details
    // it will have a name and registration(uniquely identifies)
    // the outlet detail will associate it with an outlet.
    public Scooty(String name, String registration, Outlet outletDetail){
        this.name = name;
        this.registration = registration;
        this.outletDetail = outletDetail;
    }

    public void setVehicleStatus(VehicleStatus stateOfVehicle){
        this.status = stateOfVehicle;
    }

    // block a vehicle for registration (register for trip)
    public VehicleStatus getVehicleStatus() {
        return status;
    }
    
    public String getVehicleRegistration() {
        return registration;
    }

    public String getVehicleName() {
        return name;
    }

    public Outlet getOutletDetais(){
        return outletDetail;
    }
}
