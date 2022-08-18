package com.wisetap.scootyrental.commands;

import java.util.List;
import com.wisetap.scootyrental.entities.User;
import com.wisetap.scootyrental.exceptions.OutletFullException;
import com.wisetap.scootyrental.exceptions.VehicleIsNotFreeException;
import com.wisetap.scootyrental.services.UserService;
import com.wisetap.scootyrental.services.VehicleRentalService;

public class EndRentingAVehicle implements ICommand {

    private VehicleRentalService vehicleService;
    private UserService userService;

    public EndRentingAVehicle(VehicleRentalService vehicleService, UserService userService){
        this.vehicleService = vehicleService;
        this.userService = userService;
    }

    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        String userName = tokens.get(1);
        String vehicleRegistrationDetails = tokens.get(2);
        User user = userService.getUser(userName).get();
        
        try{
            vehicleService.endTripWithVehicle(user, vehicleRegistrationDetails);
        }catch(VehicleIsNotFreeException exception){
            System.out.println(exception.getMessage());
        }catch(OutletFullException exception){
            System.out.println(exception.getMessage());
        }
    }
    
}
