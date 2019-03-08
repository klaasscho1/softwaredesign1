package RootElement.ClassDiagram.Package1;

import javax.vecmath.Vector3d;

import simbad.sim.EnvironmentDescription;

public class BumperRobotFactory implements ARobotFactory {

	@Override
	public Robot createRobot(String name, EnvironmentDescription environment) {
		return new Robot_Bumper(new Vector3d(0,0,6), name);
	}

}
