package main.java.softdesign;

import  simbad.sim.*;
import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;
import simbad.sim.RangeSensorBelt;
import simbad.sim.LampActuator;

public class Robot_bumper extends Robot {
	RangeSensorBelt bumper;
	CameraSensor camera;
	LampActuator lamp;
	
	
	public Robot_bumper (Vector3d position, String name) {     
        super(position,name);
        bumper = RobotFactory.addBumperBeltSensor(this, 10);
        lamp = RobotFactory.addLamp(this);
        setCanBeTraversed(false);
    }
    
    public void initBehavior() {
    	super.initBehavior();
    	lamp.setOn(true);
    	lamp.setBlink(false);
    }
    
    //Function responsible of changing the lamp state and
    // printing the bumper sensor that was hit
    public void bump(){
    	boolean fix = lamp.getOn();
    	if (fix) {
    		lamp.setOn(false);
    		lamp.setBlink(true);
    	}else{
    		lamp.setBlink(false);
    		lamp.setOn(true);
    	}
      	if(getCounter() % 20 == 0) {
			for(int i = 0; i < bumper.getNumSensors(); i++) {
				
				boolean hit = bumper.hasHit(i);
				if(hit){
					System.out.println("Bumper : " + i + " bumped!");
				}
				
			}
		}
    }
    
    public void performBehavior() {
    	super.performBehavior();
        if (collisionDetected()) {
        	bump();
        } else {
        	setColor(new Color3f(0,255,0));
        }
    }
}