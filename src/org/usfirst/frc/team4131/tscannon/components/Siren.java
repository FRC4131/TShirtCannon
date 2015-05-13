package org.usfirst.frc.team4131.tscannon.components;

import org.usfirst.frc.team4131.lib.components.Component;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;

public class Siren extends Component{
	private Relay siren;
	public Siren(int siren){
		super(null);
		this.siren = new Relay(siren);
	}
	public void set(boolean on){siren.set(on ? Value.kForward : Value.kOff);}
	@Override public void stop(){siren.set(Value.kOff);}
}
