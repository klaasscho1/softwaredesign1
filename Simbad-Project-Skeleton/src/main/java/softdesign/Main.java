package main.java.softdesign;
import javax.vecmath.Vector3d;

import simbad.gui.Simbad;
import simbad.sim.EnvironmentDescription;

public class Main {

	
	public static void main(String[] args) {
		
			CentralStation central = new CentralStation();
			System.setProperty("j3d.implicitAntialiasing", "true");
			EnvironmentDescription environment = new Environment();
		
			central.createCamera(environment,new Vector3d(2,0,3) ,"camera");
			central.createBumper(environment,new Vector3d(0,0,6) ,"bumper");
			central.createPicker(environment,new Vector3d(1,0,5) ,"picker");
			central.initializeMission(20, environment);
			
			Simbad frame = new Simbad(environment, false);
	      	frame.update(frame.getGraphics()); 
			
		
	}
}
