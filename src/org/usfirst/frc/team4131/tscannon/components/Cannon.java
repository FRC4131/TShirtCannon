package org.usfirst.frc.team4131.tscannon.components;

import org.usfirst.frc.team4131.lib.components.Component;
import org.usfirst.frc.team4131.tscannon.TShirtCannon;

import edu.wpi.first.wpilibj.*;

public class Cannon extends Component{
	private Solenoid[] cylinders;
	private DigitalOutput[] indicators;
	private int index = 0;
	public Cannon(int[] cylinders, int[] indicators){
		super(null);
		this.cylinders = new Solenoid[cylinders.length];
		for(int i=0;i<cylinders.length;i++) this.cylinders[i] = new Solenoid(TShirtCannon.PCM_ID, cylinders[i]);
		this.indicators = new DigitalOutput[indicators.length];
		for(int i=0;i<indicators.length;i++) this.indicators[i] = new DigitalOutput(indicators[i]);
	}
	@Override
	public void stop(){
		for(Solenoid cylinder : cylinders) cylinder.set(false);
		for(DigitalOutput indicator : indicators) indicator.set(false);
	}
	public void engage(){cylinders[index].set(true);}
	public void disengage(){cylinders[index].set(false);}
	public void next(){
		indicators[index].set(false);
		if(index + 1 < cylinders.length) index++; else index = 0;
		indicators[index].set(true);
	}
	public void prev(){
		indicators[index].set(false);
		if(index > 0) index--; else index = cylinders.length - 1;
		indicators[index].set(true);
	}
	public int getPosition(){return index;}
}
