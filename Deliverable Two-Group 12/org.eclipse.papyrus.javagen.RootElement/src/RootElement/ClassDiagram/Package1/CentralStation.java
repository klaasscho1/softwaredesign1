package RootElement.ClassDiagram.Package1;
import javax.vecmath.Vector3d;

import  simbad.sim.*;

import java.util.List;
import java.util.Map;

import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;


	
	public class CentralStation {
		
		CentralStation(){
			
		}
		
		public void initializeRobots(EnvironmentDescription environment, Map<String, ARobotFactory> robots) {
			for (Map.Entry<String, ARobotFactory> entry : robots.entrySet())
			{
			    ARobotFactory factory = entry.getValue();
			    Robot robot = factory.createRobot(entry.getKey(), environment);
			    environment.add(robot);
			}
		}
	}
