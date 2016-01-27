package mow.it.now.logic;

import java.util.List;

public class MowExecutor {
	Lawn pelouse;
	List<Mower> mowers;
	
	public MowExecutor(Lawn pelouse, List<Mower> mowers) {
		super();
		this.pelouse = pelouse;
		this.mowers = mowers;
	}
	
	public void Run()
	{
		for(Mower t : mowers)
		{
			t.RunProgram(pelouse);
			System.out.println(t.toString());
		}
	}

	/**
	 * @return the pelouse
	 */
	public Lawn getPelouse() {
		return pelouse;
	}

	/**
	 * @param pelouse the pelouse to set
	 */
	public void setPelouse(Lawn pelouse) {
		this.pelouse = pelouse;
	}

	/**
	 * @return the mowers
	 */
	public List<Mower> getTondeuses() {
		return mowers;
	}

	/**
	 * @param mowers the mowers to set
	 */
	public void setTondeuses(List<Mower> mowers) {
		this.mowers = mowers;
	}	
}
