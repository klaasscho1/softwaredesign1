package main.java.softdesign;
import java.util.HashMap;
import java.util.Map;

import javax.vecmath.Vector3d;

import simbad.gui.Simbad;
import simbad.sim.EnvironmentDescription;

public class Main {

	
	public static void main(String[] args) {
		
			CentralStation central = new CentralStation();
			System.setProperty("j3d.implicitAntialiasing", "true");
			EnvironmentDescription environment = new Environment();
			
			Map<String, ARobotFactory> robots = new HashMap<String, ARobotFactory>() {{
		        put("bumper", new BumperRobotFactory());
		        put("camera", new CameraRobotFactory());
		        put("picker", new PickerRobotFactory());
		    }};
					
			central.initializeRobots(environment, robots);
			
			Simbad frame = new Simbad(environment, false);
	      	frame.update(frame.getGraphics()); 
			
		
	}
}
