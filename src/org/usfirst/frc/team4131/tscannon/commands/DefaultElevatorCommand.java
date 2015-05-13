package org.usfirst.frc.team4131.tscannon.commands;

import static org.usfirst.frc.team4131.tscannon.TShirtCannon.elevator;
import static org.usfirst.frc.team4131.tscannon.TShirtCannon.oi;

import org.usfirst.frc.team4131.lib.commands.DefaultCommand;

public class DefaultElevatorCommand extends DefaultCommand{
	public DefaultElevatorCommand(){super(elevator);}
	@Override protected void execute(){elevator.elevate(oi.elevation());}
}
