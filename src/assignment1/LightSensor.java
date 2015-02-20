//Jesse Rosechild, Lucas Fares
//February 19, 2015
//Beloit College IDST 274
//Assignment 1
//LightSensor

package assignment1;

import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.robotics.subsumption.Behavior;

public class LightSensor implements Behavior {
	private static EV3ColorSensor cs = new EV3ColorSensor(SensorPort.S3);		//initialize color sensor cs
	//cs.setFloodlight(false);													// turn off ambient LED
	SensorMode brightness = cs.getAmbientMode();								// set color sensor to assess brightness
	private boolean suppressed = false;
		
			public boolean takeControl() {
				float[] csample = new float[brightness.sampleSize()];			//get color sensor state csample
				cs.fetchSample(csample, 0);										//check array - Index 0 is 0.0 darkest, 1.0 brightest
				while (csample[0]>.6){											//set suppressed = true if bright light
					return true;												
				}
				return suppressed;
			}

		   public void suppress() {
			   	suppressed = true;												//standard practice for suppress methods
		   }

		   public void action() {
			   																	//drive backward if see bright light
			   suppressed = false;
			   Motor.B.setSpeed(300);
			   Motor.C.setSpeed(300);
			   Motor.B.backward();
			   Motor.C.backward();
		   }
}

