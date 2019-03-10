// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package RootElement.ClassDiagram.Package1;

import java.util.HashMap;
import java.util.Map;

import javax.vecmath.Vector3d;

import java.util.HashMap;
import java.util.Map;

import javax.vecmath.Vector3d;

import simbad.gui.Simbad;
import simbad.sim.EnvironmentDescription;

/************************************************************/
/**
 * 
 */
public class Main {

	
	public static void main(String[] args) {
		
			CentralStation central = new CentralStation();
			System.setProperty("j3d.implicitAntialiasing", "true");
			EnvironmentDescription environment = new Environment();
			
			Map<String, ARobotFactory> robots = new HashMap<String, ARobotFactory>() {{
		        put("bumper", new BumperRobotFactory());
		        put("camera", new CameraRRobotFactory());
		        put("picker", new PickerRobotFactory());
		    }};
					
			central.initializeRobots(environment, robots);
			
			Simbad frame = new Simbad(environment, false);
	      	frame.update(frame.getGraphics()); 
			
		
	}
}
