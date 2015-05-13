package org.usfirst.frc.team4131.tscannon.commands;

import static org.usfirst.frc.team4131.tscannon.TShirtCannon.drive;
import static org.usfirst.frc.team4131.tscannon.TShirtCannon.oi;

import org.usfirst.frc.team4131.lib.commands.DefaultCommand;

public class DefaultDriveCommand extends DefaultCommand{
	public DefaultDriveCommand(){super(drive);}
	@Override protected void execute(){drive.drive(oi.x(), oi.y(), oi.rotation(), false);}
}
