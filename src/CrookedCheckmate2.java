
public class CrookedCheckmate2 extends checkmate // subclassing
{
	public CrookedCheckmate2()
	{
		crapsTable.println("  CrookedDie2's constructor called.");
	}

	public void roll() // can you see what this computes?
	{
		// call the inherited method to get lastRoll from parent Die parts

		callTheInheritedMethodToGetFinalRoll();
	}

	private void callTheInheritedMethodToGetFinalRoll()
	{
		int examRoll = getFinalRoll();

		if (examRoll == 6)
			this.setFinallRoll(1);
		else
			this.setFinallRoll(examRoll + 1);
	}

	public String toString()
	{
		return "A CrookedDie2 rolling 1,2,3,4,5,6 in sequence, and... ";
	}

}
