package com.wisetap.scootyrental.entities;

import java.util.HashMap;
import java.util.Map;

import com.wisetap.scootyrental.exceptions.OutletFullException;
import com.wisetap.scootyrental.exceptions.VehicleDoesNotExistException;
import com.wisetap.scootyrental.exceptions.VehicleIsNotFreeException;

public class Outlet {
    // name 
    private String name;
    private static final Integer parkingSlots = 20;
    
    // location details
    private Integer XCoordinate;
    private Integer YCoordinate;
    
    // vehicles associated
    private Map<String, Vehicle> vehicleMap;

    // Define outlet
    public Outlet(String name, Integer XCoordinate, Integer YCoordinate) {
        this.name = name;
        this.XCoordinate = XCoordinate;
        this.YCoordinate = YCoordinate;
        this.vehicleMap = new HashMap<String, Vehicle>();
    }   

    // checks to ensure that we have parking space available
    public boolean validateIfParkingSpaceAvaiableInTheOutlet() throws OutletFullException {
        boolean result = vehicleMap.size() <= parkingSlots ? true : false;
        if(result){
            throw new OutletFullException("This outlet's parking is full. Please park at another outlet.");
        }
        return result;
    }  
    
    // add vehicle to outlet
    public void addVehicle(Vehicle vehicle) throws VehicleIsNotFreeException, OutletFullException {
        validateIfParkingSpaceAvaiableInTheOutlet();
        if(VehicleStatus.NOTPICKED.equals(vehicle.getVehicleStatus())){
            vehicleMap.put(vehicle.getVehicleRegistration(), vehicle);
        }else if(VehicleStatus.RETURNED.equals(vehicle.getVehicleStatus())){
            vehicle.setVehicleStatus(VehicleStatus.NOTPICKED);
            vehicleMap.put(vehicle.getVehicleRegistration(), vehicle);
        }else{
            throw new VehicleIsNotFreeException("This vehicle is still booked");
        }
    }
    
    // remove vehicle
    public void removeVehicle(Vehicle vehicle) throws VehicleDoesNotExistException {
        if(vehicleMap.get(vehicle.getVehicleRegistration()) == null)
        throw new VehicleDoesNotExistException("This vehicle does not belong to this outlet");
        vehicleMap.remove(vehicle.getVehicleRegistration());
    }
    
    public Integer getXCoordinate() {
        return XCoordinate;
    }

    public Integer getYCoordinate() {
        return YCoordinate;
    }

    public Double getDistanceFromUser(User user){
        Integer userXCoordinate = user.getXCoordinate();
        Integer userYCoordinate = user.getYCoordinate();

        Integer xDistance = Math.abs(XCoordinate - userXCoordinate);
        Integer yDistance = Math.abs(YCoordinate - userYCoordinate);;
        // calculate distance for each one of them.
        Double distanceBetweenUserAndOutlet = Math.hypot(xDistance, yDistance);

        return distanceBetweenUserAndOutlet;
    }

    public void getVehicles(){
        for(Vehicle vehicle : vehicleMap.values()){
            if(VehicleStatus.NOTPICKED.equals(vehicle.getVehicleStatus())){
                System.out.println(vehicle.getVehicleName() + " " + vehicle.getVehicleRegistration());
            }
        }
    } 

    @Override
    public String toString() {
        return name+"_"+XCoordinate+"_"+YCoordinate;
    }
}
