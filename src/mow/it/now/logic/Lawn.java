package mow.it.now.logic;

public class Lawn {
	
	int height;
	int width;
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int largeur) {
		this.width = largeur;
	}
	
	public Lawn(int width, int height) {
		super();
		this.height = height;
		this.width = width;
	}
	
	public boolean isValid(int x, int y)
	{
		return x < width && x >= 0 && y < height && y >= 0; 
	}
}
