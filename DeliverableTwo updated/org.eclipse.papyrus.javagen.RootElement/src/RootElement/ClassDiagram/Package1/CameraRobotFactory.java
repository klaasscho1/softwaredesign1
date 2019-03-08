package RootElement.ClassDiagram.Package1;

import javax.vecmath.Vector3d;

import simbad.sim.EnvironmentDescription;

public class CameraRobotFactory implements ARobotFactory {
	@Override
	public Robot createRobot(String name, EnvironmentDescription environment) {
		return new Robot_Camera(new Vector3d(2,0,3), name);
	}

}
