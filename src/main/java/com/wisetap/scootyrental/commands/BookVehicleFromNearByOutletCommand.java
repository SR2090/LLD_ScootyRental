package com.wisetap.scootyrental.commands;

import java.util.List;

import com.wisetap.scootyrental.entities.User;
import com.wisetap.scootyrental.exceptions.VehicleDoesNotExistException;
import com.wisetap.scootyrental.services.UserService;
import com.wisetap.scootyrental.services.VehicleRentalService;

public class BookVehicleFromNearByOutletCommand implements ICommand{
    
    private VehicleRentalService vehicleService;
    private UserService userService;

    public BookVehicleFromNearByOutletCommand(VehicleRentalService vehicleService, UserService userService) {
        this.vehicleService = vehicleService;
        this.userService = userService;
    }

    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        // get the user name
        String userName = tokens.get(1);
        String vehicleRegistrationDetails = tokens.get(2);
        User userWhoWantsToBook = userService.getUser(userName).get();
        try{
            vehicleService.bookAVehicle(userWhoWantsToBook, vehicleRegistrationDetails);
        }catch(VehicleDoesNotExistException e){
            System.out.println(e.getMessage());
        }
    }
    
}
