package com.wisetap.scootyrental.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.wisetap.scootyrental.entities.Outlet;
import com.wisetap.scootyrental.entities.Scooty;
import com.wisetap.scootyrental.entities.User;
import com.wisetap.scootyrental.entities.Vehicle;
import com.wisetap.scootyrental.exceptions.OutletFullException;
import com.wisetap.scootyrental.exceptions.VehicleIsNotFreeException;

public class ScootyRentalService implements VehicleRentalService{
    // repository 
    private List<Outlet> outletLists;
    private static final Integer numberOfOutlets = 5;
    private static final Integer numberOfVehicles = 10;
    Map<Double, Outlet> nearestOutletMap = new TreeMap<Double, Outlet>();

    ScootyRentalService() throws VehicleIsNotFreeException, OutletFullException{
        outletLists  = new ArrayList<>();
        // outlets spread across a 1000 by 1000 grid
        for(Integer i = 0 ; i < numberOfOutlets; i++){
            outletLists.add(new Outlet("Single Outlet for demo " + i, getRandomNumber(-1000,1000) , getRandomNumber(-1000, 1000) ));
        }
        Integer i = 0;
        // add vehicles to outlet
        for(Outlet outlet : outletLists){
            outlet.addVehicle(new Scooty("Model X1" + i,outlet.toString()+i, outlet));
            i++;
        }
    }

    @Override
    public void rentASingleVehicleForTrip(User user) {
        // TODO Auto-generated method stub
        // get user latitude longitude
        for(Outlet outlet : outletLists) {
            nearestOutletMap.put(outlet.getDistanceFromUser(user), outlet);
        }
        Outlet nearestOutletMap =  nearestOutletMap.get(nearestOutletMap.firstKey());
    }

    @Override
    public void returnRentedVehicleAfterTrip(User user) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void viewNearByVehicleRentingOutletsForUser(User user) {
        // TODO Auto-generated method stub
        
    }
    
    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
