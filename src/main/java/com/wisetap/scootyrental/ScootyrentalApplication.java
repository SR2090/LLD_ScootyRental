package com.wisetap.scootyrental;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wisetap.scootyrental.appconfig.ApplicationConfiguration;
import com.wisetap.scootyrental.commands.CommandInvoker;
import com.wisetap.scootyrental.exceptions.CommandNotFoundException;

@SpringBootApplication
public class ScootyrentalApplication {

	public static void main(String[] args) {
		List<String> commandLineArgs = new LinkedList<>(Arrays.asList(args));
		run(commandLineArgs);
	}
	public static void run(List<String> commandLineArgs) {
		ApplicationConfiguration appConfig = new ApplicationConfiguration();
		CommandInvoker commandInvoker = appConfig.getCommandInvoker();
		BufferedReader reader;
		String inputFile = commandLineArgs.get(0);
		commandLineArgs.remove(0);
		try {
			reader = new BufferedReader(new FileReader(inputFile));
			String line = reader.readLine();
			while (line != null) {
				List<String> tokens = Arrays.asList(line.split(" "));
				commandInvoker.executeCommand(tokens.get(0),tokens);
				// read next line
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CommandNotFoundException e) {
			e.printStackTrace();
		}
	}
}
