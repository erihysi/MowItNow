package mow.it.now.logic;

public enum Instruction {
	FORWARD("A"),
	LEFT("G"),
	RIGHT("D");
	
	private final String name;
	
	private Instruction(final String name) {
        this.name = name;
    }
	
	public String getName()
	{
		return name;
	}
	
    @Override
    public String toString() {
        return name;
    }

	public static Instruction Parse(String text) {
		for(Instruction i : Instruction.values())
		{
			if(i.getName().equals(text))
				return i;
		}
		return null;
	}	
}
