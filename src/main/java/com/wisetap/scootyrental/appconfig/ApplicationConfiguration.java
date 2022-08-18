package com.wisetap.scootyrental.appconfig;

import com.wisetap.scootyrental.commands.BookVehicleFromNearByOutletCommand;
import com.wisetap.scootyrental.commands.CommandInvoker;
import com.wisetap.scootyrental.commands.CreateUserCommand;
import com.wisetap.scootyrental.commands.EndRentingAVehicle;
import com.wisetap.scootyrental.exceptions.OutletFullException;
import com.wisetap.scootyrental.exceptions.VehicleIsNotFreeException;
import com.wisetap.scootyrental.services.ScootyRentalService;
import com.wisetap.scootyrental.services.UserService;
import com.wisetap.scootyrental.services.VehicleRentalService;

public class ApplicationConfiguration {
    private final UserService userService = new UserService(); 
    private VehicleRentalService vehicleService;
    private final CommandInvoker commandInvoker = new CommandInvoker();
    public ApplicationConfiguration() {
        try{
            vehicleService = new ScootyRentalService();
        }catch(VehicleIsNotFreeException exception){
            System.out.println("Application Configuration Exception " + exception.getMessage());
        }catch(OutletFullException exception){
            System.out.println("Application Configuration Exception " + exception.getMessage());
        }   
    }
    private final CreateUserCommand userCommand = new CreateUserCommand(userService);
    private final EndRentingAVehicle endRentingVehicleCommand = new EndRentingAVehicle(vehicleService, userService);
    private final BookVehicleFromNearByOutletCommand bookAVehicle = new BookVehicleFromNearByOutletCommand(vehicleService, userService);
    
    public CommandInvoker getCommandInvoker() {
        commandInvoker.registerCommand("CREATE_USER", userCommand);
        commandInvoker.registerCommand("END_BOOKING", endRentingVehicleCommand);
        commandInvoker.registerCommand("BOOK_VEHICLE", bookAVehicle);
        return commandInvoker;
    }
}
