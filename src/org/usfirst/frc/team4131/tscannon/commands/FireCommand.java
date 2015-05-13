package org.usfirst.frc.team4131.tscannon.commands;

import static org.usfirst.frc.team4131.tscannon.TShirtCannon.cannon;

import org.usfirst.frc.team4131.lib.commands.BaseCommand;

import edu.wpi.first.wpilibj.Timer;

public class FireCommand extends BaseCommand{
	private Timer timer = new Timer();
	private boolean hasFired = false;
	public FireCommand(){super(cannon);}
	@Override
	protected void initialize(){
		super.initialize();
		timer.reset();
		timer.start();
		hasFired = false;
	}
	@Override
	protected void execute(){
		if(timer.get() < 0.25 && !hasFired){
			cannon.engage();
			hasFired = true;
		}else{cannon.disengage();}
	}
	@Override protected boolean isFinished(){return hasFired;}
	@Override protected void stop(){timer.stop();}
}
