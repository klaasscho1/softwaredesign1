package main.java.softdesign;
import javax.vecmath.Vector3d;

import simbad.gui.Simbad;
import simbad.sim.EnvironmentDescription;

public class Main {

	
	public static void main(String[] args) {
		
		
			System.setProperty("j3d.implicitAntialiasing", "true");
			EnvironmentDescription environment = new Environment();
			Robot_cam camera = new Robot_cam(new Vector3d(2,0,3), "camera");
			Robot_bumper bumper = new Robot_bumper(new Vector3d(0,0,6), "robot_bumper");
			Robot_picker picker = new Robot_picker(new Vector3d(1,0,5), "robot_picker", environment);
			
			environment.add(camera);
			environment.add(bumper);
			environment.add(picker);
			
			Simbad frame = new Simbad(environment, false);
	      	frame.update(frame.getGraphics()); 
			
		
	}
}
