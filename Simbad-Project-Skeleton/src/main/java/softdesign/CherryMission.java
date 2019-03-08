package main.java.softdesign;

public class CherryMission {
	private int numberOfCherriesPicked;
	private int numberOfCherriesGoal;
	
	
	CherryMission(){
		numberOfCherriesPicked = 0;
		numberOfCherriesGoal = 0;
	}
	
	//sets the goal number of cherries to pick which is also how 
	//many cherries will be spawned in the environment.
	public void setNumberOfCherries(int newNumberOfCherries){
		numberOfCherriesGoal = newNumberOfCherries;
	}
	
	//Number of cherries left to pick. 
	public int getNumberOfCherriesLeft(){
		return numberOfCherriesPicked;
	}
	
	//checks wether the mission goal is completed or not.
	//print statements have been commented out because it spams the output console
	public Boolean missionStatus(){
		if(numberOfCherriesGoal == 0){
			//System.out.println("No mission has been set");
			return false;
		}
		
		if(numberOfCherriesPicked == numberOfCherriesGoal){
			//System.out.println("The mission is complete");
			return true;
		}
		else {
			//System.out.println("The mission is not complete yet");
			return false;
		}
	}
	
	//increments the number of cherries picked by 1.
	public void cherryPicked(){
		numberOfCherriesPicked++;
		System.out.println("Cherry picked ! There are " + (numberOfCherriesGoal - numberOfCherriesPicked) + " left");
	}
	
	
}
