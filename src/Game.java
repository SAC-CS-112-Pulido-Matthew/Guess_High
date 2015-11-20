// Test 2
// Question 1
// A) In main the program starts by asking how many times the user would like to play the game.
//	  Then a for loop is used to play the game the specified amount of times.
//	  In the beginning of the main for loop the user enters the number of dice to roll.
//	  Then the class is instantiated and an if statement is used to determine the respective roll variations.
//	  After that the user is asked to enter a guess.
//	  Then an if statement is used to determine if the user earns a point or loses a point.
//	  Finally points and numbers of rounds are displayed as well as all the rolls and guesses for each play through the game.
//	  
// B) The class Dice attributes one private and one public. The Dice class has three methods including the constructor.
//	  The constructor has one argument which is the amount of dice the user wants to roll.
//	  The methods simply display the high and low range values for the specified number of dice.
//
// C) I used an if else statement for the methods lowRange and highRange. One if statement was used to represent when dice is one,
//	  and an else statement was used to represent when dice does not equal one. When dice is one the range is simple. I noticed that
//	  the increments of dice change the range in fixed amounts: the low value for lowRange is the ( number of dice plus one )then subtracted by
//	  one and the high value for lowRange is the number of dice times 3. In the highRange method the change is similar to lowRange: low value
//	  for highRange is the ( number of dice times 3 ) plus one and the high value for highRange is the number of dice times 3.
//
// D) The winner is determined by comparing the roll and guess integer arrays in main. If the guess is the roll or a number within
//	  plus or minus 3 units from roll then the user earns a point, if not the user loses a point.
//
// E) Points are awarded if the user wins and if the user loses then the uses loses a point.
//
// F) Points are awarded in the same if else statement describe in question d.
// 
// G) Points are counted every iteration of the main for loop and stored in an integer variable win.
// 
// H) The most simple way is through trial and error. I just entered different variations of numbers to make sure my logic was correct.
//
// I) I debugged my program by experimenting with different values and justifying myself if the output is correct for my intentions.

import java.util.Random;
import java.util.Scanner;
public class Game 
{

	public static void main(String[] args) 
	{
		int dice;
		int win = 0;
		int count = 0;
		Scanner input = new Scanner(System.in);
		
		System.out.print("How many times would you like to play the game? "); // user enters how many times they want to play.
		count = input.nextInt();
		int []roll =  new int [count]; // array used to keep track of rolls.
		int []guess = new int [count]; // array used to keep track of guesses.
		
		
		for (int i = 0; i < count; i++) // game plays for the amount of games specified by user.
		{
			System.out.print("Enter the number of dice to roll: "); // user enters number of dice to roll.
			dice = input.nextInt();
			
			Dice game = new Dice(dice); // instantiate the class Dice, to use the methods in the Dice class.
										// the single parameter (in this case dice) is the amount of dice to roll.
			if (dice == 1) // gets the roll if dice is 1.
			{
				int range = (dice * ((6 - 1)) + 1);     
				roll[i] = (int)(Math.random() * range) + 1;
			}
			else // gets the roll if dice is not 1
			{
				Random r = new Random();
				roll[i] = r.nextInt((6 * dice) - (dice) + 1) + dice;
			}
			
			System.out.print("You rolled the dice, guess the number it landed on."
					+ "\nIn order to win your guess must be (+ or -) 3 units from the roll or equal to roll): "); 
																								 // guess has to be equal to the roll or less
			guess[i] = input.nextInt();															 // than or equal to (roll + 3)
																								 // and greater than or equal to (roll - 3).
	
			System.out.println(roll[i]);
			
			game.lowRange();
			game.highRange();
			
			if ((roll[i] == guess[i] || (roll[i] - 3 <= guess[i] && guess[i] <= roll[i] + 3))) // guess has to be correct +-3 units to win.
			{
				System.out.println("You win! +1 point!\n\n");
				win++; // keeps track of win.
			}
			else
			{
				System.out.println("You lose! -1 point!\n\n");
				win--; // keeps track of loss
			}
			
		}
		
		System.out.printf("You played the game %d time(s).\n", count); // displays the number of games played.
		System.out.printf("You have %d point(s).\n", win); //displays total points.
		System.out.println("The roll and guess for each game is:");
		for (int i = 0; i < count; i++)
		{
			System.out.printf("%d) roll: %d. guess: %d\n", i + 1, roll[i], guess[i] ); // uses a for loop to output the roll and guess for
																					   // each game.
		}
		
	}

}
