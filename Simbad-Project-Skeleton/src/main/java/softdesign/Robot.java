package main.java.softdesign;

import  simbad.sim.*;

import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;

public class Robot extends Agent {
    
	public double velocity = 0.5;
	public double rotation = 0;
	//used to store the current life time of the agent
	public double storeTime = 0.0;
	
	public Robot (Vector3d position, String name) {     
        super(position,name);
    }
    
    public void initBehavior() {}
    
    public void performBehavior() {
        if (collisionDetected()) {
            // stop the robot
        	
        	rotateY(180);
//        	while(storeTime < 10000){
//            	setColor(new Color3f(255,0,0));
            setTranslationalVelocity(velocity);         
            setRotationalVelocity(0);
//                storeTime++;
//        	}

        } else {
        	
            // progress at 0.5 m/s
            setTranslationalVelocity(velocity);
            // frequently change orientation 
            if ((getCounter() % 100)==0) 
               setRotationalVelocity(Math.PI/2 * (0.5 - Math.random()));
        }
    }
}
