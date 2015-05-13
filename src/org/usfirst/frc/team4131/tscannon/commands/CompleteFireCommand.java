package org.usfirst.frc.team4131.tscannon.commands;

import org.usfirst.frc.team4131.lib.commands.ExtendedCommand;
import org.usfirst.frc.team4131.lib.commands.MultiCommand;

public class CompleteFireCommand extends MultiCommand{
	public CompleteFireCommand(){
		super(new ExtendedCommand(3, new LightsCommand(true), new SirenCommand(true)), ADD_SEQUENTIAL, new FireCommand());
		//Activate the lights and siren for 3 seconds, then fire
	}
	
}
