package main.java.softdesign;


import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;

import  simbad.sim.*;

public class Robot_cam extends Robot {
	CameraSensor camera;
	
	public Robot_cam (Vector3d position, String name) {     
        super(position,name);
        camera = RobotFactory.addCameraSensor(this); 
        setCanBeTraversed(false);
    }
	
	 public void initBehavior() {
		 super.initBehavior();
	 }
	    
	    public void performBehavior() {
	    	super.performBehavior();
	    	if(!collisionDetected()) {
	        	setColor(new Color3f(0,0,0));
	            
	        }
	    }
	    
}




