package main.java.softdesign;

import simbad.sim.EnvironmentDescription;

public interface ARobotFactory {
	public Robot createRobot(String name, EnvironmentDescription environment);
}
