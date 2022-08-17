package com.wisetap.scootyrental.commands;

import java.util.List;

public interface ICommand {
    public void execute(List<String> tokens);
}
