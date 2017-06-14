
public class checkmate
{
	private int finalRoll;

	public checkmate()
	{
		// CrapsGame.println("Die's constructor called.");
		this.roll();
	}

	public checkmate(int firstAmount) // overloaded constructor: different signature
	{
		setFinallRoll(firstAmount);
	}

	public int getFinalRoll() // getter or accessor method
	{

		return this.finalRoll;
	}

	// protected => visible to subclasses and package
	protected void setFinallRoll(int lastRoll) // setter or mutator method
	{
		this.finalRoll = lastRoll;
	}

	public void roll() // note how this changes Die's state, but doesn't return anything
	{
		setFinallRoll((int) (Math.random() * 6 + 1));
	}

	// try changing visibility of toString to protected...
	@Override
	public String toString() // this OVERRIDES the default Object.toString()
	{
		return "A Die object with roll " + this.getFinalRoll();

		// add the following to the end of the above line:
		// + " " + super.toString()
	}

	public String toString(int msg) // Overloading... but NOT overriding!
	{
		return msg + this.toString();
	}
}
