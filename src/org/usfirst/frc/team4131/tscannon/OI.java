package org.usfirst.frc.team4131.tscannon;

import static org.usfirst.frc.team4131.lib.oi.XBoxController.*;

import org.usfirst.frc.team4131.lib.commands.InstantCommand;
import org.usfirst.frc.team4131.lib.commands.OverrideCommand;
import org.usfirst.frc.team4131.lib.oi.BaseController.ControllerButton;
import org.usfirst.frc.team4131.lib.oi.XBoxController;
import org.usfirst.frc.team4131.tscannon.commands.*;

public class OI{
	private XBoxController main, demo;
	private ControllerButton buttonFire, buttonOverride;
	private boolean driverOriented = false;
	public OI(int slotMain, int slotDemo){
		main = new XBoxController(slotMain);
		demo = new XBoxController(slotDemo);
		buttonFire = main.button(A);
		buttonFire.onPress(new CompleteFireCommand());
		buttonFire.onRelease(new OverrideCommand(TShirtCannon.cannon, TShirtCannon.lights, TShirtCannon.siren));
		buttonOverride = main.button(Y);
		main.button(SCREEN_SELECT).onPress(new InstantCommand(){
			public void activate(){driverOriented = !driverOriented; super.execute();}//Toggle driver orientation
		});
		main.button(LEFT_BUMPER).onPress(new InstantCommand(){public void activate(){TShirtCannon.cannon.prev();}});//Back up launcher
		main.button(RIGHT_BUMPER).onPress(new InstantCommand(){public void activate(){TShirtCannon.cannon.next();}});//Advance launcher
		main.button(X).onPress(new LightsCommand(true)).onRelease(new LightsCommand(false));
		main.button(B).onPress(new SirenCommand(true)).onRelease(new SirenCommand(false));
	}
	public double x(){return getAxis(LEFT_X, 0.5);}
	public double y(){return getAxis(LEFT_Y, 0.5);}
	public double rotation(){return getAxis(RIGHT_X, 0.5);}
	public boolean canFire(){return buttonFire.get();}
	public boolean override(){return buttonOverride.get();}
	public double elevation(){return getAxis(RIGHT_TRIGGER, 0.75) - getAxis(LEFT_TRIGGER, 0.75);}
	//Utility method that returns demo controller's value (with multiplier) unless not connected or overridden
	private double getAxis(int axis, double demoMult){
		return demo.isConnected() && !override() ? demo.getAxis(axis) * demoMult : main.getAxis(axis);
	}
}
