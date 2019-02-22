package main.java.softdesign;

import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;


import simbad.demo.Demo;
import simbad.sim.Agent;
import simbad.sim.CherryAgent;
import simbad.sim.EnvironmentDescription;

import simbad.sim.SimpleAgent;

public class Robot_picker extends Demo {
   
	private double velocity = 0.5;
	private double rotation = 0;
	private int noOfCherries = 30;
	
    public class Robot extends Agent {
      
        public Robot(Vector3d position, String name) {
        super(position, name);
         
        }

        public void initBehavior() {
            setTranslationalVelocity(0.5);
        }

        public void performBehavior() {
            if (collisionDetected()){
            	rotateY(180);
            	setTranslationalVelocity(velocity);         
            	setRotationalVelocity(rotation);
            	
            }else{
            	 // progress at 0.5 m/s
                setTranslationalVelocity(velocity);
                
		//If all cherries are collected, go back to star position and stay there
                if (noOfCherries == 0){
                	moveToStartPosition();
                	setRotationalVelocity(0);
                	setTranslationalVelocity(0);
                	System.out.print("All the cherries have been picked!");
                }
		    
		// frequently change orientation 
                if ((getCounter() % 100)==0) 
                   setRotationalVelocity(Math.PI/2 * (0.5 - Math.random()));
		    
		//If there is another agent and it is a cherry, pick it
                if (anOtherAgentIsVeryNear()){
                    SimpleAgent agent = getVeryNearAgent();
                    if (agent instanceof CherryAgent){
                        // detach it from the scene graph so it is no more visible.
                    	noOfCherries -= 1;
                        agent.detach();
                        System.out.println("Cherry picked !");
                    }
                    
                
            }
            }
        }
    }
   
    //Class responsibe of the creation of the robot and cherries
    public  Robot_picker(Vector3d position, String name, EnvironmentDescription environment) {
		
	// add the robot
    	Robot picker = new Robot(position, name);
    	picker.setColor(new Color3f(255,0,0));
        environment.add(picker);
        
        // add cherries randomly 
        
        for( int n =0; n < noOfCherries;n++){
            double x =( Math.random()*20 - 10);
            double z = (Math.random()*20 - 10);
            environment.add(new CherryAgent(new Vector3d(x, 0, z), "cherry", 0.3f));
        }
    }

}
