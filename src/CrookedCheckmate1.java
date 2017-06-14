
public class CrookedCheckmate1 extends checkmate
{
	public CrookedCheckmate1()
	{
		crapsTable.println("  CrookedDie1's constructor called.");
		
	}

	public int getFinalRoll() // this OVERRIDES Die's getLastRoll(), replacing
								// it!
	{
		return 3;
	}

	public String toString() // this OVERRIDES Die's toString()
	{
		return "A CrookedDie1 always rolling 3, and... " + super.toString();
	}

}
