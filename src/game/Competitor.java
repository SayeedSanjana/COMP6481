package game;

/**
 * This is the class that contains all methods replated to the players of the game
 * @author Sanjana Sayeed
 */
//ID: 40237987
//COMP6481
//Assignment01 Part02
//Due Date : February 16th 2023

public class Competitor {
	private String playerType;
	private int noOfShips;
	private int noOfGrenades;
	
	/**
    *Default constructor of Competitor class
    */
	public Competitor() {
		this.noOfShips=6;
		this.noOfGrenades=4;
		this.playerType="Computer";
		
	}
	
	/**
    *Constructor of Competitor class that takes a string as parameter
    *@param type holds the type of the player
    */
	public Competitor(String type) {
		noOfShips=6;
		noOfGrenades=4;
		playerType=type;
		
	}
	
	/**
    *This is a method that will return the number of ships for the player
    *@return noOfShips Number of ships
    */
	public int getShipNumber() {
		return noOfShips;
	}
	
	/**
    *This is a method that will return the number of grenade for the player
    *@return noOfGrenades Number of grenades
    */
	public int getGrenadeNumber() {
		return noOfGrenades;
	}
	
	/**
    *This is a method that will return the type of the player
    *@return playerType 
    */
	public String getPlayerType() {
		return playerType;
	}
	
	/**
    *This is a method that will reduce the number of ships by 1 when ship is hit
    */
	public void strikeShip() {
		noOfShips--;
	}
	
	/**
    *This is a method that will reduce the number of grenade by 1 when grenade is hit
    */
	public void strikeGrenade() {
		noOfGrenades--;
	}

}
