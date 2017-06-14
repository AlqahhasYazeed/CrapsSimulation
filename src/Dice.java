/**
 * Dice represents a single pair of rollable Die objects, randomly generating
 * sums of their two values
 * 
 * This is a Javadoc comment: add more to your finished class below
 * 
 * @author eric
 *
 */
public class Dice
{
	// Instance fields (variables) may be declared anywhere in class body
	// Convention: put at top

	private int finalRoll;
	private checkmate checkmate1;
	private checkmate checkmate2;

	// Constructors (object initializers) also can be declared anywhere
	// Convention: after instance fields/variables

	public Dice()
	{
		// initialize instance variables die1 and die2 by
		// creating a new instance of each

		creatingNewinstanceForEachVariables();
	}

	private void creatingNewinstanceForEachVariables()
	{
		this.checkmate1 = new checkmate();
		this.checkmate2 = new checkmate();
		this.roll();
	}

	public Dice(checkmate die1, checkmate die2) // overloaded constructor
	{
		this.checkmate1 = die1;
		this.checkmate2 = die2;
	}

	// Instance methods can also be declared anywhere
	// Convention: after constructors

	public int getFinalRoll()
	{
		return this.finalRoll;
	}

	public void roll()
	{
		// roll each of die1, die2, sum their last rolls,
		// then set Dice.lastRoll to this value

		rollEachOfVaruablesAndSumTheirFinalRolls();

	}

	private void rollEachOfVaruablesAndSumTheirFinalRolls()
	{
		checkmate1.roll();
		checkmate2.roll();
		this.finalRoll = checkmate1.getFinalRoll() + checkmate2.getFinalRoll();
	}

	// the following method converts the internals of
	// this Dice object, and returns a descriptive String:
	//
	// Roll of 7 => 4 + 3
	//

	public String toString()
	{
		return "Roll of " + getFinalRoll() + ": " + checkmate1.getFinalRoll() + " + " + checkmate2.getFinalRoll();

	}

	// static methods can go anywhere - but at end is standard

	public static final int NUM_TRIALS = 360;

	public static void main(String[] args)
	{
		Dice dice1 = new Dice();
		int snakeEyesCount = 0;

		for (int i = 0; i < NUM_TRIALS; i++)
		{
			snakeEyesCount = actionIfNumOFTrialsBigerThanI(dice1, snakeEyesCount);
		}

		StdOut.println("Actual count: " + snakeEyesCount);
		StdOut.println("Expected count: " + (NUM_TRIALS / 36.0));
	}

	private static int actionIfNumOFTrialsBigerThanI(Dice dice1, int snakeEyesCount)
	{
		dice1.roll();
		StdOut.println(dice1);
		
		if (dice1.getFinalRoll() == 2)
			snakeEyesCount++;
		return snakeEyesCount;
	}
}
