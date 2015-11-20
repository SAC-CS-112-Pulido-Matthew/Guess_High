
public class Dice
	{
		private int dice = 0;
		public int roll = 0;
							  // this constructor is called as soon as the class is instantiated.
		public Dice(int dice) // connects the dice that the user enters to the private data member dice in the dice class.
		{
			this.dice = dice; 
		}
		
		public void lowRange() // this method displays the low range for the number of dice specified.
		{
			if (dice == 1)
			{
				System.out.printf("Low Range: %d - %d.\n", 1, 3);
			}
			
			else
			{
				System.out.printf("Low Range: %d - %d.\n", ((1 + dice) - 1), ((3 * dice)));
			}
		}
		
		public void highRange() // this method displays the high range for the number of dice specified.
		{
			if (dice == 1)
			{
				System.out.printf("High Range: %d - %d.\n", 4, 6);
			}
			
			else
			{
				System.out.printf("High Range: %d - %d.\n", ((3 * dice) + 1), ((6 * dice)));
			}
		}
	}
