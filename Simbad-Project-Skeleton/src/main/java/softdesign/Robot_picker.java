package main.java.softdesign;

import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;

import simbad.sim.Agent;
import simbad.sim.CherryAgent;
import simbad.sim.SimpleAgent;

public class Robot_picker extends Agent {
	private double velocity = 0.5;
	private double rotation = 0;
	//used to store the current life time of the agent
	private double storeTime = 0.0;
	private int objectsLeft = 30;
	
	public Robot_picker (Vector3d position, String name) {     
        super(position, name);
    }
    
    public void initBehavior() {
    	setTranslationalVelocity(0.5);
    }
    
    public void performBehavior() {
    	// Test if there is an agent near .
        if (anOtherAgentIsVeryNear()){
        	System.out.println("Another agent is near. Object?");
            SimpleAgent agent = getVeryNearAgent();
            
            if (agent instanceof CherryAgent){
                // detach it from the scene graph so it is no more visible.
                agent.detach();
                objectsLeft -= 1;
                System.out.println("Object picked. " + String.valueOf(objectsLeft) + " left.");
                
                if(objectsLeft == 0) {
                	System.out.println("All objects picked!");
                	// return to base point and stop moving.
                	moveToStartPosition();
                	setTranslationalVelocity(0);
                	setRotationalVelocity(0);
                }
            }
            
        }
    	
    	if (collisionDetected()) {
        	rotateY(180);

            setTranslationalVelocity(velocity);         
            setRotationalVelocity(rotation);

        } else {
        	
        	setColor(new Color3f(10,0,0));
        	
            // progress at 0.5 m/s
            setTranslationalVelocity(velocity);
            
            // frequently change orientation 
            if ((getCounter() % 100)==0) 
               setRotationalVelocity(Math.PI/2 * (0.5 - Math.random()));
        }
    }
}
