package org.usfirst.frc.team4131.tscannon;

import org.usfirst.frc.team4131.lib.Robot;
import org.usfirst.frc.team4131.tscannon.components.*;

public class TShirtCannon extends Robot{
	public static final int PDP_ID = 1, PCM_ID = 2;
	public static final DriveBase drive = new DriveBase(3, 4, 5, 6);
	public static final Elevator elevator = new Elevator(7);
	public static final Cannon cannon = new Cannon(new int[]{0, 1, 2, 3, 4, 5}, new int[]{0, 1, 2, 3, 4, 5});
	public static final Lights lights = new Lights(0);
	public static final Siren siren = new Siren(1);
	public static final Sensors sensors = new Sensors(0);
	public static final OI oi = new OI(0, 1);
	private TShirtCannon(){super(null);}
}
