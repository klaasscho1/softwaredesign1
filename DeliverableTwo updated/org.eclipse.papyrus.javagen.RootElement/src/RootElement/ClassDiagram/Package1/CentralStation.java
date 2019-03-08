package RootElement.ClassDiagram.Package1;

import javax.vecmath.Vector3d;
import  simbad.sim.*;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;

public class CentralStation {
	
	Robot_Camera camera;
	Robot_Bumper bumper;
	Robot_Picker picker;
	CherryMission mission = new CherryMission();
	
	int numberOfRobots;
	Point3d coords = new Point3d(0,0,0);
	
	
	CentralStation(){
		numberOfRobots = 0;
	}
	
	//creates a robot equiped with a camera
	public void createCamera(EnvironmentDescription environment, Vector3d position, String name){
		numberOfRobots++;
		environment.add(camera = new Robot_Camera(position,name));
	}
	
	//creates a robot equiped with a bumper and a light
	public void createBumper(EnvironmentDescription environment, Vector3d position, String name){
		numberOfRobots++;
		environment.add(bumper = new Robot_Bumper(position,name));
	}
	
	//creates a robot that will pick cherries if it encounters them
	public void createPicker(EnvironmentDescription environment, Vector3d position, String name){
		numberOfRobots++;
		picker = new Robot_Picker(position,name,mission,environment);
	}
	
	//gets the number of robots currently in the system
	public int getNumberOfRobots(){
		return numberOfRobots;
	}
	
	//test function to get information from the robots
	public void getStatus(){
		System.out.println(camera.getName());
		camera.getCoords(coords);
	}
	
	//initializes the number of cherries for the mission and the number of cherries to be place in the 
	//environment
	public void initializeMission(int numberOfCherries, EnvironmentDescription environment){
		mission.setNumberOfCherries(numberOfCherries);
		for( int n =0; n < numberOfCherries;n++){
	        double x =( Math.random()*20 - 10);
	        double z = (Math.random()*20 - 10);
	        environment.add(new CherryAgent(new Vector3d(x, 0, z), "cherry", 0.3f));
	    }
	}
}