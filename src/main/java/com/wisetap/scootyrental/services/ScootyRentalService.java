package com.wisetap.scootyrental.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;


import com.wisetap.scootyrental.entities.Outlet;
import com.wisetap.scootyrental.entities.Reservation;
import com.wisetap.scootyrental.entities.ReservationStatus;
import com.wisetap.scootyrental.entities.Scooty;
import com.wisetap.scootyrental.entities.User;
import com.wisetap.scootyrental.entities.Vehicle;
import com.wisetap.scootyrental.exceptions.OutletFullException;
import com.wisetap.scootyrental.exceptions.VehicleDoesNotExistException;
import com.wisetap.scootyrental.exceptions.VehicleIsNotFreeException;

public class ScootyRentalService implements VehicleRentalService{
    // repository 
    private List<Outlet> outletLists;
    private List<Reservation> reservations; 
    private List<Vehicle> allVehicles;

    private static final Integer numberOfOutlets = 5;
    private static final Integer numberOfVehicles = 10;
    Map<Double, Outlet> nearestOutletMap = new TreeMap<Double, Outlet>();

    public ScootyRentalService() throws VehicleIsNotFreeException, OutletFullException{
        outletLists  = new ArrayList<>();
        allVehicles = new ArrayList<>();
        reservations = new ArrayList<>();

        // outlets spread across a 1000 by 1000 grid
        for(Integer i = 0 ; i < numberOfOutlets; i++){
            outletLists.add(new Outlet("Single Outlet for demo " + i, getRandomNumber(-1000,1000) , getRandomNumber(-1000, 1000) ));
        }
        
        // add vehicles to outlet
        for(Outlet outlet : outletLists){
            for(Integer i = 0; i < numberOfVehicles ; i++){
                Vehicle newVehicle = new Scooty("Model X1" + i,outlet.toString()+i, outlet);
                outlet.addVehicle(newVehicle);
                allVehicles.add(newVehicle);
            }
        }  
    }

    @Override
    public void listNearestOutletsAndTheirAvailableVehicles(User user) {
        // TODO Auto-generated method stub
        // get user latitude longitude
        // find the nearest outlet to user location
        ServiceUtil.sortOutlets(outletLists, user);
        System.out.println("Vehicles at the nearest outlet");
        for(Outlet outlet : outletLists){
            outlet.getVehicles();
        }
    }

    @Override
    public void bookAVehicle(User user, String vehicleRegistrationDetails) throws VehicleDoesNotExistException{
        // TODO Auto-generated method stub
        ServiceUtil.sortOutlets(outletLists, user);
        Vehicle selectedVehicle = allVehicles.stream().filter(vehicles -> vehicles.getVehicleRegistration().equals(vehicleRegistrationDetails)).findFirst().get();
        Reservation newVehicleBooking = new Reservation(user, ReservationStatus.BOOKING, selectedVehicle);
        Outlet selectedVehicleOutlet = selectedVehicle.getOutletDetais();
        selectedVehicleOutlet.removeVehicle(selectedVehicle);
        reservations.add(newVehicleBooking);
    }
    
    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    @Override
    public void endTripWithVehicle(User user, String vehicleRegistrationDetails) throws VehicleIsNotFreeException, OutletFullException {
        // TODO Auto-generated method stub
        // get the nearest outlet to where the user can park
        ServiceUtil.sortOutlets(outletLists, user);
        Optional<Reservation> existingvehicleReservation = reservations.stream().filter(reservation -> user.getUserName().equals(reservation.getRegisteredUser().getUserName())).findFirst();
        if(!existingvehicleReservation.isEmpty()){
            Outlet nearestOutlet = outletLists.get(0);
            Vehicle selectedVehicle = allVehicles.stream().filter(vehicles -> vehicles.getVehicleRegistration().equals(vehicleRegistrationDetails)).findFirst().get();
            nearestOutlet.addVehicle(selectedVehicle);
            reservations.remove(existingvehicleReservation.get());
        }
    }
}
