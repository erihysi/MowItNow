package mow.it.now.logic;

public enum Direction {
	NORTH("N",1),
	EAST("E",1),
	SOUTH("S",-1),
	WEST("W",-1);
	
	private int coeff;
	private String name;
	Direction(String name,int coeff)
	{
		this.name = name;
		this.coeff = coeff;
	}
	
	public int getCoeff()
	{
		return this.coeff;
	}
	
	public String getName()
	{
		return this.name;
	}

	public static Direction Parse(String name) {
		Direction[] directions = Direction.values();
		for(Direction d : directions)
		{
			if(d.getName().equals(name))
				return d;
		}
		return null;
	}
}
