package main.java.softdesign;

import  simbad.sim.*;


import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;
import simbad.sim.RangeSensorBelt;
import simbad.sim.LampActuator;


public class Robot_bumper extends Agent {
    
	private double velocity = 0.5;
	private double rotation = 0;
	//used to store the current life time of the agent
	//private double storeTime = 0.0;
	RangeSensorBelt bumper;
	CameraSensor camera;
	LampActuator lamp;
	
	
	public Robot_bumper (Vector3d position, String name) {     
        super(position,name);
        bumper = RobotFactory.addBumperBeltSensor(this, 10);
        lamp = RobotFactory.addLamp(this);
       
        
    }
    
    public void initBehavior() {
    	lamp.setOn(true);
    	lamp.setBlink(false);
    }
    
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
				//double range = bumper.getMeasurement(i);
				boolean hit = bumper.hasHit(i);
				if(hit){
					System.out.println("Bumper : " + i + " bumped!");
				}
				
			}
		}
    }
    
    public void performBehavior() {
        if (collisionDetected()) {
            // stop the robot
        	
        	
        	bump();
        	rotateY(180);
        
//        	while(storeTime < 10000){
//            	setColor(new Color3f(255,0,0));
            setTranslationalVelocity(velocity);         
            setRotationalVelocity(rotation);
//                storeTime++;
//        	}

        } else {
        	
        	
        	setColor(new Color3f(0,255,0));
        	
            // progress at 0.5 m/s
            setTranslationalVelocity(velocity);
            // frequently change orientation 
            if ((getCounter() % 100)==0) 
               setRotationalVelocity(Math.PI/2 * (0.5 - Math.random()));
            
        }
    }
}
