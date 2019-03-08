package main.java.softdesign;

import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;


import simbad.demo.Demo;
import simbad.sim.Agent;
import simbad.sim.CherryAgent;
import simbad.sim.EnvironmentDescription;

import simbad.sim.SimpleAgent;

public class Robot_picker extends Robot {
	CherryMission mission;
	
    //Class responsible of the creation of the robot and cherries
    public Robot_picker(Vector3d position, String name , CherryMission newMission, EnvironmentDescription environment) {
    	// add the robot
    	super(position, name);
    	setColor(new Color3f(255,0,0));
    	mission = newMission;
    }
	
    public void initBehavior() {
    	super.initBehavior();
        setTranslationalVelocity(0.5);
    }

    public void performBehavior() {
    	super.performBehavior();
        if (!collisionDetected()){
            
            //If all cherries are collected, go back to star position and stay there
            if (mission.missionStatus()){
            	moveToStartPosition();
            	setRotationalVelocity(0);
            	setTranslationalVelocity(0);
            }
	    
            //If there is another agent and it is a cherry, pick it
            if (anOtherAgentIsVeryNear()){
                SimpleAgent agent = getVeryNearAgent();
                if (agent instanceof CherryAgent){
                    // detach it from the scene graph so it is no more visible.
                	mission.cherryPicked();
                    agent.detach();
                }
                
            
        }
        }
    }
   

}
