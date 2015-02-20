//rosechildja
//February 19, 2015
//Beloit College
//Arbitrator

package assignment1;

//import lejos.hardware.port.SensorPort;
//import lejos.hardware.sensor.EV3TouchSensor;
//import lejos.robotics.SampleProvider;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class Assignment1 {
	
	   public static void main(String [] args) {
		  Behavior b1 = new DefaultState();								//4th priority behavior: drive forward
	      Behavior b2 = new DistanceSensor();							//3rd priority behavior: check distance sensor, slow & turn response
	      Behavior b3 = new LightSensor();								//2nd priority behavior: check light sensor, drive backward response
	      Behavior b4 = new TouchSensor();								//1st priority behavior: check touch sensor, drive forward response
	      Behavior [] bArray = {b1, b2, b3, b4};
	      Arbitrator arby = new Arbitrator(bArray);
	      arby.start();
	   }
	}		
