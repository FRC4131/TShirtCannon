package org.usfirst.frc.team4131.tscannon.components;

import org.usfirst.frc.team4131.lib.components.Component;

import edu.wpi.first.wpilibj.Gyro;

public class Sensors extends Component{
	private Gyro gyro;
	public Sensors(int gyro){
		super(null);
		this.gyro = new Gyro(gyro);
	}
	public double gyro(){return gyro.getAngle();}
	public void reset(){gyro.reset();}
	@Override public void stop(){}
}
