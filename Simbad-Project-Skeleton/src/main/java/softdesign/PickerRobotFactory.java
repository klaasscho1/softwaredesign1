package main.java.softdesign;

import javax.vecmath.Vector3d;

import simbad.sim.CherryAgent;
import simbad.sim.EnvironmentDescription;

public class PickerRobotFactory implements ARobotFactory {
	CherryMission mission = new CherryMission();
	
	public void initializeMission(int numberOfCherries, EnvironmentDescription environment){
		mission.setNumberOfCherries(numberOfCherries);
		for( int n =0; n < numberOfCherries;n++){
	        double x =( Math.random()*20 - 10);
	        double z = (Math.random()*20 - 10);
	        environment.add(new CherryAgent(new Vector3d(x, 0, z), "cherry", 0.3f));
	    }
	}

	@Override
	public Robot createRobot(String name, EnvironmentDescription environment) {
		initializeMission(30, environment);
		return new Robot_picker(new Vector3d(1,0,5), name, mission);
	}

}
