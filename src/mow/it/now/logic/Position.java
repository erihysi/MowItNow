package mow.it.now.logic;

public class Position {
	private int x;
	private int y;
	
	public Position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public Position(Position p) {
		super();
		this.x = p.getX();
		this.y = p.getY();
	}
	
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	
}
