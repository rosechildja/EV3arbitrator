//Jesse Rosechild, Lucas Fares
//February 19, 2015
//Beloit College IDST 274
//Assignment 1
//DefaultState

package assignment1;

import lejos.hardware.motor.Motor;
import lejos.robotics.subsumption.Behavior;

public class DefaultState implements Behavior {
	   private boolean suppressed = false;
	   
	   public boolean takeControl() {
	      return true;
	   }

	   public void suppress() {
	      suppressed = true;													//standard practice for suppress methods
	   }

	   public void action() {
		   																		//drive forward as default
		 suppressed = false;
		 Motor.B.setSpeed(350);
		 Motor.C.setSpeed(350);
		 Motor.B.forward();
		 Motor.C.forward();
	     while( !suppressed )													//do not interrupt until suppressed
	        Thread.yield();
	   }
	}
