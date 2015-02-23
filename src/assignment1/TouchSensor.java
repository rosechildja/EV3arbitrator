//Jesse Rosechild, Lucas Fares
//February 19, 2015
//Arbitrator - TouchSensor

package assignment1;

import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.SampleProvider;
import lejos.robotics.subsumption.Behavior;

public class TouchSensor implements Behavior {
	SampleProvider ts = new EV3TouchSensor(SensorPort.S1);				//initialize touch sensor ts
	private boolean suppressed = false;
		
		   public boolean takeControl() {
				float[] tsample = new float[ts.sampleSize()]; 		//get touch sensor state tsample
				ts.fetchSample(tsample, 0);  				//check array - Index 0 is 0.0 touched, 1.0 untouched
					while (tsample[0] == 1) {			//set suppressed = true if sensor touched
						return true;
					}
				return suppressed;
		   }

		   public void suppress() {
			   	suppressed = true;					//standard practice for suppress methods
		   }

		   public void action() {
			   								//drive forward if sensor touched
			   suppressed = false;
			   Motor.B.setSpeed(500);
			   Motor.C.setSpeed(500);
			   Motor.B.forward();
			   Motor.C.forward();
		   }
}
