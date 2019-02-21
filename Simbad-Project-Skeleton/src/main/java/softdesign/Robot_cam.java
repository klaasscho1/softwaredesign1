package main.java.softdesign;


import simbad.sim.Agent;


import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;
import simbad.sim.CameraSensor;

import  simbad.sim.*;

public class Robot_cam extends Agent {

	private double velocity = 0.5;
	private double rotation = 0;
	//used to store the current life time of the agent
	//private double storeTime = 0.0;
	CameraSensor camera;
	
	
	public Robot_cam (Vector3d position, String name) {     
        super(position,name);
        camera = RobotFactory.addCameraSensor(this);
       
    }
	 public void initBehavior() {}
	    
	    public void performBehavior() {
	        if (collisionDetected()) {

	        	rotateY(180);

	            setTranslationalVelocity(velocity);         
	            setRotationalVelocity(rotation);

	        } else {
	        	
	        	setColor(new Color3f(0,0,0));
	        	
	            // progress at 0.5 m/s
	            setTranslationalVelocity(velocity);
	            
	            // frequently change orientation 
	            if ((getCounter() % 100)==0) 
	               setRotationalVelocity(Math.PI/2 * (0.5 - Math.random()));
	            
	            
	        }
	    }
}


