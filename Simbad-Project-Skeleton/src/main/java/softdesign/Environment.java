package main.java.softdesign;

import java.awt.Color;

import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;

import simbad.sim.*;
import simbad.sim.Box;
import simbad.sim.EnvironmentDescription;
import simbad.sim.Wall;

//import simbad.sim.BallAgent;


public class Environment extends EnvironmentDescription{
	
	public static final int WORLD_SIZE = 25;
		
	public Environment() {
		// turn on the lights
        this.light1IsOn = true;
        this.light2IsOn = true;
        
        // enable the physics engine in order to have better physics effects on the objects
        //this.setUsePhysics(true);
        
        
        // show the axes so that we know where things are
        this.showAxis(true);
        
        // Set the world size
        this.setWorldSize(25);
        
        //Creating the Walls 
        
        Wall topWall = new Wall(new Vector3d(-12.5,0, 0), 25, 2, this);
        topWall.setColor(new Color3f(Color.GREEN));
        topWall.rotate90(1);
        add(topWall);
        
        Wall bottomWall = new Wall(new Vector3d(12.5, 0, 0), 25, 2, this);
        bottomWall.setColor(new Color3f(Color.BLUE));
        bottomWall.rotate90(1);
        add(bottomWall);
        
        Wall leftWall = new Wall(new Vector3d(0, 0, 12.5), 25, 2, this);
        leftWall.setColor(new Color3f(Color.BLACK));
        add(leftWall);
        
        Wall rigthWall = new Wall(new Vector3d(0, 0, -12.5), 25, 2, this);
        rigthWall.setColor(new Color3f(Color.YELLOW));
        add(rigthWall);
        
        Box b1 = new Box(new Vector3d(-3, 0 , 3), new Vector3f(1, 1, 1), this);
        b1.setColor(new Color3f(Color.BLACK));
        add(b1);
        
        Box b2 = new Box(new Vector3d(6, 0 , -6), new Vector3f(1, 1, 1), this);
        b2.setColor(new Color3f(Color.BLACK));
        add(b2);
        
        
        Arch a1 = new Arch(new Vector3d(3, 0, -3), this);
        a1.rotate90(1);
        add(a1);
        
        Wall interiorOne = new Wall(new Vector3d(-4, 0, -4), 4, 2, this);
        interiorOne.setColor(new Color3f(Color.BLUE));
        add(interiorOne);
        
        Wall interiorSecond = new Wall(new Vector3d(-5,0,-3),2,2,this);
        interiorSecond.rotate90(1);
        interiorSecond.setColor(blue);
        add(interiorSecond);
        
        
        light1IsOn = true;
        light2IsOn = true;
        
        light1SetPosition(6,.7f,5);
        light2SetPosition(9,.7f,2);
        
        light1Color = white;
        light2Color = white;
       
		
	}
};
