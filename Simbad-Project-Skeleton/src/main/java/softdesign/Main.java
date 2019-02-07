package main.java.softdesign;


import simbad.gui.*;
import simbad.sim.*;
import javax.vecmath.Vector3d;

public class Main {

	
	public static void main(String[] args) {
		
		System.setProperty("j3d.implicitAntialiasing", "true");
		
		EnvironmentDescription environment = new Environment();
		
		Robot robot1 = new Robot(new Vector3d(0, 0, 0),"robot1");
		
		environment.add(robot1);
		
		
        Simbad frame = new Simbad(environment, false);
        frame.update(frame.getGraphics());
			
	}
}
