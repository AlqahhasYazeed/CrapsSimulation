///
public class crapsTable
{
	private int mark;
	private Dice dice;
	public static boolean displayOutput = true;

	public static void println(String str)
	{
		if (displayOutput)
			StdOut.println(str);
	}

	public crapsTable()
	{
		dice = new Dice();
	}

	public crapsTable(checkmate die1, checkmate die2)
	{
		dice = new Dice(die1, die2);
	}

	public boolean playOneGame(int[] wins, int[] losses)
	{
		return firstRoll(wins, losses);
	}

	private boolean firstRoll(int[] wins, int[] losses)
	{
		int steps = 1;

		// Roll the dice
		// Get the value of the roll as point
		// Print out this value as 'first roll'

		dice.roll();

		mark = dice.getFinalRoll();

		println("First roll is: " + dice.getFinalRoll());

		// If point is 7 or 11, announce an immediate win for player,
		// increment wins[steps], and return true indicating win
		
		if (mark == 7 || mark == 11)
		{
			return winForPlayer(wins, steps);
		}
		else if (mark==2 || mark == 3 || mark==12)
		{
			println("Loss for player with " + mark);
			losses[steps] = losses[steps] + 1; // number of losses with exactly steps # of steps.
			// losses[steps]++; 
			return false;
		}

		// Else if point is 2, 3, or 12, announce an immediate loss for player,
		// increment losses[steps], and return false indicating loss

		// If not an immediate win nor loss, print out point
		// roll the dice over and over, keeping track of steps,
		// and printing each rolled value until either:

		// (a) The point is again rolled => a win for player:
		// update wins[] and return true

		// (b) 7 is rolled => a loss for player:
		// update losses[] and return false
		
		else // point rolled: keep going until point rerolled OR 7 rolled
		{
			println("Point is: " + mark);
			
			int value = 0;
			do
			{
				dice.roll();
				steps++;
				value = dice.getFinalRoll();
				println("Next roll is: " + value);
			}
			while (value != 7 && value != mark);
	
			// the following is equivalent to the above.
			// Is it easier to understand?
			
//			while (true)
//			{
//				dice.roll();
//				value = dice.getLastRoll();
//				println("Next roll is: " + value);
//				if (value==7)
//					break;
//				if (value==point)
//					break;
//			}
			
			if (value==7)
			{
				// loss: record losses and return false
				println("You lose throwing a 7.");
				losses[steps]++;
				return false;
			}
			else if (value==mark)
			{
				// win: record wins and return false
				println("You win by throwing your point " + value);
//				wins[steps]++;
				return true;

			}
		}

		return false;
	}

	private boolean winForPlayer(int[] wins, int steps)
	{
		return winNWithStepN(wins, steps);
	}

	private boolean winNWithStepN(int[] wins, int steps)
	{
		println("Win for player with " + mark);
		wins[steps] = wins[steps] + 1; // number of wins with exactly steps # of steps.
		 wins[steps]++; 
		return true;
	}

	public static void main(String[] args)
	{
		// play a game!
	}
}
