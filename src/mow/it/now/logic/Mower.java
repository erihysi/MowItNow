package mow.it.now.logic;

import java.util.List;

public class Mower {
	private Position position;
	private Direction direction;
	private List<Instruction> program;
	
	public Mower() 
	{
	}
	

	public Mower(Position position, Direction direction, List<Instruction> instructions) {
		this.position = position;
		this.direction = direction;
		this.program = instructions;
	}


	/**
	 * @return the direction
	 */
	public Direction getDirection() {
		return direction;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	/**
	 * @return the program
	 */
	public List<Instruction> getProgram() {
		return program;
	}

	/**
	 * @param program the program to set
	 */
	public void setProgram(List<Instruction> program) {
		this.program = program;
	}
	
	/**
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}


	/**
	 * @param position the position to set
	 */
	public void setPosition(Position position) {
		this.position = position;
	}

	public void RunProgram(Lawn p) {
		for(Instruction i : program)
		{
			switch(i)
			{
				case FORWARD: 
					move(p);
					break;
				case LEFT:
					direction = Direction.values()[direction.ordinal() == 0 ? 3 : direction.ordinal() - 1 ];
					break;
				case RIGHT:
					direction = Direction.values()[(direction.ordinal() + 1) % 4];
					break;
			}
		}		
	}

	private void move(Lawn p) {
		int x = position.getX();
		int y = position.getY();
		switch(direction)
		{
			case NORTH : 
			case SOUTH : 
				y += direction.getCoeff();
				break;
			case WEST :
			case EAST:
				x += direction.getCoeff();
				break;
		}
		if(p.isValid(x, y))
		{
			position = new Position(x, y);
		}
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return position.getX() + " " + position.getY() + " " + direction.getName();
	}
}


