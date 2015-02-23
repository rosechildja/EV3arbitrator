//Jesse Rosechild, Lucas Fares
//February 19, 2015
//Arbitrator - DistanceSensor

package assignment1;

import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.robotics.SampleProvider;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;

public class DistanceSensor implements Behavior {
	private static EV3UltrasonicSensor us = new EV3UltrasonicSensor(SensorPort.S2);	//initialize ultrasonic sensor us
	SampleProvider distance = us.getDistanceMode();					//set ultrasonic sensor to assess distance
	private boolean suppressed = false;
		
			public boolean takeControl() {
				
				float[] usample = new float[distance.sampleSize()];	//get ultrasonic sensor state usample
				us.fetchSample(usample, 0);				//check array - distance in meters
				while (usample[0]<.5){					//set suppressed = true if distance < .5 meter
					return true;												
				}
				return suppressed;
			}

		   public void suppress() {
			   	suppressed = true;					//standard practice for suppress methods
		   }

		   public void action() {
			   								//slow if dist < .5 meters, check sensor, turn if dist < .3 meters
			   suppressed = false;
			   Motor.B.setSpeed(150);
			   Motor.C.setSpeed(150);
			   Motor.B.forward();
			   Motor.C.forward();
			   SampleProvider distance = us.getDistanceMode();		//set ultrasonic sensor to assess distance
			   float[] usample = new float[distance.sampleSize()];		//get ultrasonic sensor state usample
			   us.fetchSample(usample, 0);					//check array - distance in meters						
			   while (usample [0] < .3) {
				   Motor.B.stop();
				   Motor.C.stop();
				   Motor.B.setSpeed(400);
				   Motor.C.setSpeed(400);
				   Motor.B.forward();
			       Motor.C.backward();
			       Delay.msDelay(1100);					//wait for 1.1 seconds (prevents interrupt during turn)
			       us.fetchSample(usample, 0);				//check array - distance in meters
			   }
		   }
}
