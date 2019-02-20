package main.java.softdesign;

import java.awt.Color;

import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;

import simbad.sim.*;
import simbad.sim.Box;
import simbad.sim.EnvironmentDescription;
import simbad.sim.Wall;

public class Environment extends EnvironmentDescription{
	
	public static final int WORLD_SIZE = 25;
		
	public Environment(){
		this.light1IsOn = true;
		
		
	    // enable the physics engine in order to have better physics effects on the objects
	    //this.setUsePhysics(true);
	        
	    // show the axes so that we know where things are
	    //this.showAxis(true);
	        
	    //sets the world plane size to 25 by 25
	    this.setWorldSize(WORLD_SIZE);
	    
	    //creates the plane and the obstacles
	    this.light1SetPosition(-8, 2, 0);
	    //this.light2SetPosition(4, 5, 2);
	   
		
        add(new Box(new Vector3d(7,0,-7), new Vector3f(2,2,2), this));
        add(new Box(new Vector3d(5,0,-5), new Vector3f(2,2,2), this));
        add(new Box(new Vector3d(3,0,-3), new Vector3f(2,2,2), this));
        
        add(new Arch(new Vector3d(-3,0,3), this));
        
        
		Wall topWall = new Wall(new Vector3d(-8,0, 0), 16, 2, this);
        topWall.setColor(new Color3f(Color.BLACK));
        topWall.rotate90(1);
        add(topWall);
		
        Wall bottomWall = new Wall(new Vector3d(8, 0, 0), 16, 2, this);
        bottomWall.setColor(new Color3f(Color.RED));
        bottomWall.rotate90(1);
        add(bottomWall);
		
        Wall rightWall = new Wall(new Vector3d(0, 0, -8), 16, 2, this);
        rightWall.setColor(new Color3f(Color.BLUE));
        //topWall.rotate90(1);
        add(rightWall);
        
		Wall leftWall = new Wall(new Vector3d(0, 0, 8), 16, 2, this);
		leftWall.setColor(new Color3f(Color.YELLOW));
        //topWall.rotate90(1);
        add(leftWall);
        
        //Cherries
        for(int n = 0; n<10; n ++){
        	int x = (int) (Math.random() * ( 7 + 7)) -7;
        	int y = (int) (Math.random() * ( 7 + 7)) -7;
        	
        	add(new CherryAgent(new Vector3d(x, 0, y), "cherry", 0.4f));
        }
        
        for(int n = 0; n<10; n ++){
        	int x = (int) (Math.random() * ( 7 + 7)) -7;
        	int y = (int) (Math.random() * ( 7 + 7)) -7;
        	
        	add(new CherryAgent(new Vector3d(x, 0, y), "cherry", 0.3f));
        }
        
        
       
        
        
        
		
	}
};
