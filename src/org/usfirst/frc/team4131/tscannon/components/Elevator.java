package org.usfirst.frc.team4131.tscannon.components;

import org.usfirst.frc.team4131.lib.components.Component;
import org.usfirst.frc.team4131.tscannon.commands.DefaultElevatorCommand;

import edu.wpi.first.wpilibj.CANTalon;

public class Elevator extends Component{
	private CANTalon elevator;
	public Elevator(int elevator){
		super(new DefaultElevatorCommand());
		this.elevator = new CANTalon(elevator);
	}
	public void elevate(double value){elevator.set(value);}
	@Override public void stop(){elevator.set(0);}
}
