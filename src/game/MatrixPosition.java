package game;

/**
 * This is the class that contains all methods replated to MatrixPositon of the game
 * @author Sanjana Sayeed
 */
//ID: 40237987
//COMP6481
//Assignment01 Part02
//Due Date : February 16th 2023
public class MatrixPosition {
	/**
	 * Initialize row variable
	 */
	private int row;
	
	/**
	 * Initialize column variable
	 */
	private int column;
	
	/**
	 * Initialize positionCalled variable
	 */
	private boolean positionCalled;
	
	/**
	 * Initialize shipPresent variable
	 */
	private boolean shipPresent;
	
	/**
	 * Initialize grenadePresent variable
	 */
	private boolean grenadePresent;
	
	/**
	 * Initialize playerType variable
	 */
	private String playerType;
	
	/**
	 * Constructor of the MatrixPosition class that takes two string as parameter and this is for human
	 * @param playerType hold the type of the player
	 * @param enteredKey hold the coordinates entered by the human
	 */
	public MatrixPosition(String playerType, String enteredKey) {
		this.playerType=playerType;
		this.positionCalled=false;
		//Taking the first character of enterkey and converting it into an ASCII value and then converting to an int
		this.column= ((int)enteredKey.charAt(0)-65);
		//Taking the second character of enterkey and converting it into an ASCII value 
		this.row= enteredKey.charAt(1)-49;
	}
		
	/**
	 * Constructor of the MatrixPosition class that takes one string and two integers as parameters and it is for cpu
	 * @param playerType hold the type of the player
	 * @param row hold the row entered by the cpu
	 * @param col hold the col entered by the cpu
	 */
	public MatrixPosition(String playerType, int row, int col) {
		this.playerType=playerType;
		this.positionCalled=false;
		this.column= col;
		this.row= row;
	}
	
	/**
	 *This is the method that will return number of rows
	 *@return row
	 */
	public int getRow() {
		return row;
	}
	
	/**
	 *This is the method that will return number of column
	 *@return column
	 */
	public int getColoumn() {
		return column;
	}
	
	/**
	 *If ship is set in a position then this method is called to set it true
	 */
	public void isShipSet() {
		shipPresent=true;
	}
	
	/**
	 *This method is called to see if in a certain position a ship is already set
	 *@return true if ship present else false
	 */
	public boolean getShip() {
		return shipPresent;
	}
	
	/**
	 *If a grenade is set in a position then this method is called to set it true
	 */
	public void isGrenaddeSet() {
		grenadePresent=true;
	}
	
	/**
	 *This method is called to see if in a certain position a grenade is already set
	 *@return true if grenade present else false
	 */
	public boolean getGrenade() {
		return grenadePresent;
	}
	
	/**
	 *If something is placed on a certain position of the board then this method is called to set it true
	 */
	public void setPositionCalled() {
		this.positionCalled=true;
	}
	
	/**
	 *This method is called to see if in a certain position of the board
	 * is already occupied and if the position was already called
	 *@return true if positon is already called else false
	 */
	public boolean positionCalled() {
		return positionCalled;
	}
	
	/**
	 *This method is used to see the type of the player, whether the player is human or cpu
	 *@param type hold the type of the player
	 */
	public void setPlayerType(String type) {
		playerType = type;
	}
	
	/**
	 *This method is used to get the type of the player
	 *@return playerType 
	 */
	public String getPlayerType() {
		return playerType;
	}
	
	
}
