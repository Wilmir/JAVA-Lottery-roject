
import java.util.Scanner;

public class GameApp {
	
	//Main String Method
	public static void main(String[] args) {

		int counter=0;
		double total=0;
		
		
		//Initialize
		Scanner start = new Scanner(System.in);
		System.out.println("Start the game?(Y/N)");
		String newGame = start.nextLine();
		
		while(newGame.equals("Y")) {
			
			// declare an array variable with size 6 for user input of 6 numbers;  
			int[] guessNum = new int[6];
			
			// create an instance of the class Game
			Game game = new Game();
			
			//Print the randNum array
			int[] randNum = game.getRand();

			
			//Increment Game Counter
			counter++;			
			
			
			System.out.println("\n =================== GAME "+ counter + " ===================");			
			
			System.out.print("\n" +  "GUIDE FOR TESTING: The random number is: ");
				printArray(randNum);
			

			//Get user input
			Scanner in = new Scanner(System.in);
			
			//Ask the user to input 6 numbers;
			System.out.print("\n \n");
			System.out.println("Please input 6 numbers (Accepted range is 1 to 40):");
			
			
			// Iterate on all user input
			for(int i=0; i<guessNum.length; i++) {	
				guessNum[i] = in.nextInt();
			}
			
			
			//Invoke the setGuess method of the Game Class 
			game.setGuess(guessNum);
			
			
			//Print the guessNum array
			System.out.println("\n \n" + "Your number combination: ");
				printArray(guessNum);
			
			
			//Print the randNum array
			System.out.println("\n \n" +  "The winning number combination is: ");
				printArray(randNum);	
				
				
			//Invoke the compare method
			game.compareArray();
			
			//Print the number of matches
			System.out.println("\n \n" +  "You got " + game.getMatches() + " matches.");
			
			
			//Print the winning amount.
			double winning = game.getDrawResult();
			System.out.println("\n" + "You won" + " " + winning);
			System.out.println("\n ================ END OF GAME " +counter+ " ================");
			
			
			
			total += winning;
			
			//Ask the user if they wish to play another game
			System.out.println("\n Do you wish to play another game?(Y/N)");
			newGame = start.nextLine(); // update the start scanner
		}
		
		
		// Display History of all games
		System.out.println("\n ================ GAMES HISTORY ================");
		System.out.println("\n You played " + counter + " games.");
		System.out.println("\n Your average winning is: " + (total/counter));
		System.out.println("\n ============= THANKS FOR PLAYING =============");
		

	}
	
	
	//Print Array Method
	public static void printArray(int[] numArray) {
		for(int i=0;i<numArray.length; i++) {
			System.out.print(numArray[i] + " ");
		}	
	}
	
	


	
	
	
}
