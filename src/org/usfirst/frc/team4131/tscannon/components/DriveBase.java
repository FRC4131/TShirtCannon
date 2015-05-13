package org.usfirst.frc.team4131.tscannon.components;

import org.usfirst.frc.team4131.lib.components.Component;
import org.usfirst.frc.team4131.tscannon.TShirtCannon;
import org.usfirst.frc.team4131.tscannon.commands.DefaultDriveCommand;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;

public class DriveBase extends Component{
	private CANTalon[] motors;
	private RobotDrive drive;
	public DriveBase(int... ids){
		super(new DefaultDriveCommand());
		motors = new CANTalon[ids.length];
		for(int i=0;i<ids.length;i++) motors[i] = new CANTalon(ids[i]);
		drive = new RobotDrive(motors[0], motors[1], motors[2], motors[3]);
	}
	public void drive(double x, double y, double rot, boolean absolute){
		drive.mecanumDrive_Cartesian(x, y, rot, absolute ? TShirtCannon.sensors.gyro() : 0);
	}
	@Override public void stop(){for(CANTalon motor : motors) motor.set(0);}
}
