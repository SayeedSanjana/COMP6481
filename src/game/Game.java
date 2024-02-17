package game;

import java.util.Scanner;
/**
 * This is the class that contains main method and all the operation related to play the game
 * @author Sanjana Sayeed
 */

 //ID: 40237987
 //COMP6481
 //Assignment01 Part02
 //Due Date : February 16th 2023

   public class Game {
	   
	   /**
	    *Default constructor of Game class
	    */
	   public Game() {
		   
	   }
	   
	   /**
	    * Declare Competitor Object
	    */
		private Competitor cpu = new Competitor();
		
		/**
	    * Declare Competitor Object and sending String Human as parameter
	    */
		private Competitor human = new Competitor("Human");
		
		/**
	    * Initialize MatrixPosition array of size 8x8
	    */
		private MatrixPosition[][] gameBoard = new MatrixPosition[8][8];
		Scanner sc = new Scanner(System.in);
		
		/**
	    * Declare ships variable
	    */
		private int ships =6;
		
		/**
	    * Declare grenade variable
	    */
		private int grenade =4;
		
		/**
	    *Initialize row variable
	    */
		int row=0;
		
		/**
	    *Initialize col variable
	    */
		int col=0;
		
		/**
	    *Initialize p variable
	    */
		int p=0;
		
		/**
	    *Initialize q variable
	    */
		int q=0;
		
		/**
	    *Initialize x variable
	    */
		int x=0;
		
		/**
	    *Initialize y variable
	    */
		int y=0;
		
		/**
	     * This method that check if the position in the board is available to input and it takes only string as input
	     * @param keyEntered the coordinate entered by the user
	     * @return false if position is not available else true
	     */
		public boolean checkAvailablePosition(String keyEntered) {
			int column= ((int)keyEntered.charAt(0)-65);   //  converting the character to the number
			int row= keyEntered.charAt(1)-49;
			if(gameBoard[row][column]==null) {
				return true;
			}
			return false;
			
		}
		
		/**
	     * This method that check if the position in the board is available to input and it takes two integer for input, 
	     * here method overloading happening
	     * @param row takes row input given by the user
	     * @param column takes column input given by the user
	     * @return false if position is not available else true
	     */
		public boolean checkAvailablePosition(int row, int column) {
			if(gameBoard[row][column]==null) {
				return true;
			}
			return false;
			
		}
		
		/**
	     * This method that check if the input given falls within the grid of the board i.e it is column within
	     * A-H and row 0-7
	     * @param keyEntered takes the coordinates inputed by the user
	     * @return false if input is wrong else true
	     */
		public boolean checkInput(String keyEntered) {
			int column= ((int)keyEntered.charAt(0)-65);   //  converting the character to the number
			int row= keyEntered.charAt(1)-49;
			if(row>=0 && row<=7 && column>=0 && column<=7) {
				return true;
			}
			return false;
		}
		
		/**
	     * This method that check if the input given falls within the grid of the board i.e it is column and row within 0-7 
	     * @param row stores row inputed by the user
	     * @param column stores column inputed by the user
	     * @return false if input is wrong else true
	     */
		public boolean checkInput(int row, int column) {
			if(row>=0 && row<=7 && column>=0 && column<=7) {
				return true;
			}
			return false;
		}
		
		/**
	     * This method takes the coordinate from human , check the availability of the position, 
	     * also checks for correct input and if everything is correct then set ship in the board
	     * 
	     */
		public void setHumanShip() {
			for(int i=0;i<ships;i++) {
				System.out.println("Enter the coordinates of your ship #" + i);
				String coordinate = sc.nextLine();
				//check if the input given is within the grid
				if(checkInput(coordinate)){
					//check if the position is vacant to place ship
					if(checkAvailablePosition(coordinate)) {
						MatrixPosition boardPosition = new MatrixPosition(human.getPlayerType(),coordinate);
						boardPosition.isShipSet();
						gameBoard[boardPosition.getRow()][boardPosition.getColoumn()]=boardPosition;
					}
					else {
						System.out.println("sorry, coordinates already used. try again.");
						i--;
						continue;
					}
				}
				else {
					System.out.println("sorry, coordinates outside the grid. try again");
					i--;
					continue;
				}
			}
		}
		
		
		/**
	     * This method takes the coordinate from human , check the availability of the position, 
	     * also checks for correct input and if everything is correct then set grenade in the board
	     * 
	     */
		public void setHumanGrenade(){
			for(int i=0;i<grenade;i++) {
				System.out.println("Enter the coordinates of your grenade #" + i);
				String coordinate = sc.nextLine();
				//check if the input given is within the grid
				if(checkInput(coordinate)){
					//check if the position is vacant to place ship
					if(checkAvailablePosition(coordinate)) {
						MatrixPosition boardPosition = new MatrixPosition(human.getPlayerType(),coordinate);
						boardPosition.isGrenaddeSet();
						gameBoard[boardPosition.getRow()][boardPosition.getColoumn()]=boardPosition;
					}
					else {
						System.out.println("sorry, coordinates already used. try again.");
						i--;
						continue;
					}
				}
				else {
					System.out.println("sorry, coordinates outside the grid. try again");
					i--;
					continue;
				}
			}
		}
		
		/**
	     * This method randomly generate coordinates for cpu , check the availability of the position, 
	     * also checks for correct input and if everything is correct then set ship in the board
	     * 
	     */
		public void setCpuShip() {
			for(int i=0;i<ships;i++) {
				row = (int)(Math.random() * 8);
				col= (int)(Math.random() * 8);
				//check if the input given is within the grid
				if(checkInput(row,col)){
					//check if the position is vacant to place grenade
					if(checkAvailablePosition(row,col)) {
						MatrixPosition boardPosition = new MatrixPosition(cpu.getPlayerType(),row,col);
						boardPosition.isShipSet();
						gameBoard[boardPosition.getRow()][boardPosition.getColoumn()]= boardPosition;
					}else {
						i--;
						continue;
					}
				}else{
					i--;
					continue;
				}
			}
		}
		
		/**
	     * This method randomly generate coordinates for cpu , check the availability of the position, 
	     * also checks for correct input and if everything is correct then set grenade in the board
	     */
		public void setCpuGrenade() {
			for(int i=0;i<grenade;i++) {
				row = (int)(Math.random() * 8);
				col= (int)(Math.random() * 8);
				//check if the input given is within the grid
				if(checkInput(row,col)){
					//check if the position is vacant to place grenade
					if(checkAvailablePosition(row,col)) {
						MatrixPosition boardPosition = new MatrixPosition(cpu.getPlayerType(),row,col);
						boardPosition.isGrenaddeSet();
						gameBoard[boardPosition.getRow()][boardPosition.getColoumn()]= boardPosition;
					}else {
						i--;
						continue;
					}
				}else{
					i--;
					continue;
				}
			}
		}
		
		/**
	     * This technique accepts human input or produces coordinates at random if it is a CPU, 
	     * and then determines whether the position they are attempting to target has a ship, a grenade, 
	     * or an empty space. If it hits the ship, the ship count will be reduced for either the human or the CPU, 
	     * depending on which ship is struck, and if there is a grenade, the opponent will have two chances to shoot 
	     * in succession.And if the location is empty, nothing happens.
	     * @param c stores Competitor object
	     */
		public void shootRocket(Competitor c) {
			if(c.getPlayerType().equals("Computer")) {
				p = (int)(Math.random()*8);
				q = (int)(Math.random()*8);
				
				System.out.println("Position of my rocket: " + (char)(q+65) + p);
				//if board not null
				if(gameBoard[p][q]!=null) {
					if(!gameBoard[p][q].positionCalled()) {
						if(gameBoard[p][q].getShip()) {
							gameBoard[p][q].setPositionCalled();
							c.strikeShip();;
							System.out.println("ship hit");
						}else if(gameBoard[p][q].getGrenade()){
							gameBoard[p][q].setPositionCalled();
							c.strikeGrenade();
							System.out.println("boom! grenade!");
							shootRocket(human);
						}else {
							System.out.println("nothing");
						}
					}	
				}else {
					System.out.println("Nothing");
					MatrixPosition position = new MatrixPosition(c.getPlayerType(),p,q);
					gameBoard[p][q]=position;
					gameBoard[p][q].setPositionCalled();
				}
			}else if(c.getPlayerType().equals("Human")) {
				System.out.print("Position of your rocket: " );
				String input =sc.nextLine();
				y= ((int)input.charAt(0)-65) ;
				x= input.charAt(1)-49;
				//check correct input
				if(gameBoard[x][y]!=null) {
					if(!gameBoard[x][y].positionCalled()) {
						if(gameBoard[x][y].getShip()) {
							gameBoard[x][y].setPositionCalled();
							c.strikeShip();
							System.out.println("ship hit.");
						}else if(gameBoard[x][y].getGrenade()){
							gameBoard[x][y].setPositionCalled();
							c.strikeGrenade();
							System.out.println("boom! grenade.");
							shootRocket(cpu);
						}else {
							System.out.println("nothing");
						}
					}
					
				}else {
					System.out.println("Nothing");
					MatrixPosition position = new MatrixPosition(c.getPlayerType(),p,q);
					gameBoard[x][y]=position;
					gameBoard[x][y].setPositionCalled();
				}
			}
		}
		
	
		/**
	     * This method will display the game board.
	     */
		public void display() {
			for(int i=0;i<gameBoard.length;i++) {
				for(int j=0;j<gameBoard[i].length;j++) {
					//position in the board that is not null
					if(gameBoard[i][j]!=null && gameBoard[i][j].positionCalled()){
						if(gameBoard[i][j].getPlayerType().equals("Computer")) {
							//check if ship was positioned
							if(gameBoard[i][j].getShip()) {
								System.out.print("S ");
							//check if grenade was positioned
							}else if(gameBoard[i][j].getGrenade()) {
								System.out.print("G ");
							}else if(!gameBoard[i][j].getShip()&& !gameBoard[i][j].getGrenade()) {
								System.out.print("* ");
							}
						}else if(gameBoard[i][j].getPlayerType().equals("Human")){
							//check if ship was positioned
							if(gameBoard[i][j].getShip()) {
								System.out.print("s ");
							//check if grenade was positioned
							}else if(gameBoard[i][j].getGrenade()) {
								System.out.print("g ");
							}else if(!gameBoard[i][j].getShip()&& !gameBoard[i][j].getGrenade()) {
								System.out.print("* ");
							}
						}
					}
					else { 
						System.out.print("- ");
					}
				}
				System.out.println("");
			}
		}
		
		/**
	     * This method will basically initiate the game
	     */
		public void startGame() {
			System.out.println("Hi,let’s play Battleship!");
			setHumanShip();
			setHumanGrenade();
			setCpuShip();
			setCpuGrenade();
			System.out.println("OK,the computer placed its ships and grenades at random. Let’s play.");
			display();
			while(human.getShipNumber()!=0 && cpu.getShipNumber()!=0) {
				shootRocket(human);
				display();
				System.out.println("Human Ship: "+human.getShipNumber());
				System.out.println("Cpu Ship: "+cpu.getShipNumber());
				shootRocket(cpu);
				display();	
			}
			if(human.getShipNumber()==0) {
				System.out.println("Computer Wins!");
			}if(cpu.getShipNumber()==0) {
				System.out.println("You Win!");
			}
		}
		
		/**
	     * This is the main method which will declare the Game object
	     * @param args a String array to store string
	     */
		public static void main(String[] args) {
			Game g = new Game();
			g.startGame();
		}
}
