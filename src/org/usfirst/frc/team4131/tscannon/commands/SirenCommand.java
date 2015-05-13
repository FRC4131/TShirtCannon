package org.usfirst.frc.team4131.tscannon.commands;

import org.usfirst.frc.team4131.lib.commands.InstantCommand;
import static org.usfirst.frc.team4131.tscannon.TShirtCannon.siren;

public class SirenCommand extends InstantCommand{
	private boolean on;
	public SirenCommand(boolean on){super(siren); this.on = on;}
	@Override protected void activate(){siren.set(on);}
}
