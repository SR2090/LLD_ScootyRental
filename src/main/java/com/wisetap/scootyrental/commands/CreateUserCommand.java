package com.wisetap.scootyrental.commands;

import java.util.List;

import com.wisetap.scootyrental.services.UserService;

public class CreateUserCommand implements ICommand {

    private UserService userService;

    public CreateUserCommand(UserService userService){
        userService = new UserService();
    }

    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        String userName = tokens.get(1);
        String XCoordinate = tokens.get(2);
        String YCoordinate = tokens.get(3);

        userService.createUser(userName, Integer.parseInt(XCoordinate), Integer.parseInt(YCoordinate));
    }
    
}
