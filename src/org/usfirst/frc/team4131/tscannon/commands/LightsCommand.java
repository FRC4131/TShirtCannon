package org.usfirst.frc.team4131.tscannon.commands;

import org.usfirst.frc.team4131.lib.commands.InstantCommand;
import static org.usfirst.frc.team4131.tscannon.TShirtCannon.lights;

public class LightsCommand extends InstantCommand{
	private boolean on;
	public LightsCommand(boolean on){super(lights); this.on = on;}
	@Override protected void activate(){lights.set(on);}
}
