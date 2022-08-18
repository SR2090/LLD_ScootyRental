package com.wisetap.scootyrental.commands;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wisetap.scootyrental.exceptions.CommandNotFoundException;

public class CommandInvoker {

    private Map<String, ICommand> commandMap = new HashMap<String, ICommand>();

    public void registerCommand(String commandName, ICommand commandLogic) {
        commandMap.put(commandName, commandLogic);
    }

    public ICommand getCommand(String command) {
        return commandMap.get(command);
    }

    public void executeCommand(String commandName, List<String> tokens) throws CommandNotFoundException{
        ICommand command = getCommand(commandName);
        if(command == null) {
            throw new CommandNotFoundException("The specified command does not exist");
        }
        command.execute(tokens);
    }
}