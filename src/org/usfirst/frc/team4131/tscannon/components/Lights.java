package org.usfirst.frc.team4131.tscannon.components;

import org.usfirst.frc.team4131.lib.components.Component;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;

public class Lights extends Component{
	private Relay lights;
	public Lights(int lights){
		super(null);
		this.lights = new Relay(lights);
	}
	public void set(boolean on){lights.set(on ? Value.kForward : Value.kOff);}
	@Override public void stop(){lights.set(Value.kOff);}
}
