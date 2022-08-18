package com.wisetap.scootyrental.commands;

import java.util.List;

import com.wisetap.scootyrental.entities.User;
import com.wisetap.scootyrental.services.UserService;
import com.wisetap.scootyrental.services.VehicleRentalService;

public class ViewNearByOutletsCommand implements ICommand{

    private VehicleRentalService vehicleService;
    private UserService userService;

    public ViewNearByOutletsCommand(VehicleRentalService vehicleService, UserService userService){
        this.vehicleService = vehicleService;
        this.userService = userService;
    }

    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        // get the username from input
        String userName = tokens.get(1);
        User user = userService.getUser(userName).get();
        vehicleService.listNearestOutletsAndTheirAvailableVehicles(user);
    }
    
}
