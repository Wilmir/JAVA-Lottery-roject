import java.util.Random;


public class Game {
	private int[] randNum = new int[6], guessNum = new int[6];
	private int matches;
	private final double THREEMATCHES = 125.00;
	private final double FOURMATCHES = 300.00;
	private final double FIVEMATCHES = 1500.00;
	private final double JACKPOT = 1000000.00;

	
	// Default constructor generates the random number array;
	public Game() {
		Random rand = new Random();
		for (int i=0; i<6; i++) {
			randNum[i] = rand.nextInt(40) + 1;
			
			// check if randNum already exists in the array starting from 2nd input
			if(i > 0) {  
				for(int c=i-1; c>=0; c--) { //iterate comparison to all previous inputs
					if(randNum[i]==randNum[c]) { //compare existing input with previous input
						i--; // subtract one(1) from the input counter
					}
				}
			}
		
		}
	}
	
	
	//sets the guessNum array
	public void setGuess(int[] guessNum) {
		this.guessNum = guessNum;
	}
	
	
	//returns the secret number array
	public int[] getRand() {
		return randNum;
	}
	
	//compare randNum to guessNum array
	public void compareArray() {
		matches = 0;
		for(int g = 0; g<guessNum.length; g++) {
			for(int r=0; r<randNum.length; r++) {
				if(guessNum[g]==randNum[r]) {
					matches++;
				}
			}
		}
	}
	
	//returns the number of matches
	public int getMatches() {
		return matches;
	}
	
	
	
	//returns draw result
	public double getDrawResult() {
		double winning;
		if(matches < 3) {
			winning = 0;
		}
		else if(matches == 3) {
			winning = THREEMATCHES;
		} 
		else if (matches == 4) {
			winning = FOURMATCHES;
		}
		else if (matches == 5) {
			winning = FIVEMATCHES;
		} else {
			winning = JACKPOT;
		}
		
		return winning;	
	}
	

	
	
	
	
}
