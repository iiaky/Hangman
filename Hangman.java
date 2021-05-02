import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Arrays;
import java.lang.StringBuilder;

public class Hangman {
	
	public static void main(String[] args) {
		
		List<String> bank = Arrays.asList("Achievement", "Restoration", "Abruptly", "Abyss", "Subway",
				"Mnemonic", "Galaxy", "Haiku", "Vaporize", "Voodoo", "Xylophone", "Zodiac");
				// random words I stole off a website
		
		boolean Playing = false;
		
		// checking to play
		System.out.println("Play Hangman? yes/no");
		Scanner G = new Scanner(System.in);
		String qStart = G.next().toLowerCase();
		if (qStart.toLowerCase().equals("yes") || qStart.toLowerCase().equals("y")) {
			Playing = true;
		}
		
		
		if(Playing) {
			
			int Lives = 5;
			
			//getting random word
			Random num = new Random();
			int x = num.nextInt(bank.size());
			List<String> words = new ArrayList<String>();
			String choiced = bank.get(x).replace("[", "").replace("]", "").toLowerCase().strip();
			StringBuilder choice = new StringBuilder(choiced);
			// System.out.println(choice);
			
			//word length
			int L = (choice.length());
			StringBuilder gfinal = new StringBuilder("_".repeat(L));
			System.out.println("\nThe word is "+ L +" letters long.\nYou have " + Lives + " lives.\n"
								+ "(you can only enter one letter at a time)\n"+ gfinal);
			
			
			// guesses
			String guess = G.next().toLowerCase();
			StringBuilder tempchoice = new StringBuilder(choice);
			char [] Used = new char[26];

			while(Lives > 0) {
				int k = 0;
				
				if (guess.equals("quit") || guess.equals("q")) {
					break;
				}
				
				else if (Arrays.toString(Used).contains(guess)){
					System.out.println("You already used this letter");
				}
				
				else if (!choice.toString().contains(guess)){
					Lives -= 1;
					System.out.println("\nWrong letter!\nYou have " + Lives + " lives left.");
				}
				
				else{
					while (tempchoice.toString().contains(guess)){
						gfinal.replace(tempchoice.indexOf(guess), tempchoice.indexOf(guess)+1, guess);
						tempchoice.replace(tempchoice.indexOf(guess), tempchoice.indexOf(guess)+1, ".");
						}
					}

				System.out.println(gfinal);
				if(choice.toString().equals(gfinal.toString())) {
					System.out.println("\nYou win! The word is: " + choice);
					break;
				}
				else if (Lives == 0) {
					System.out.println("\nGame over! You lose! The word was: " + choice);
					break;
				}
				Used[k] = guess.charAt(0);
				k++;
				guess = G.next();
			
			}
			Playing = false;
			G.close();
			
		}
	}
}
