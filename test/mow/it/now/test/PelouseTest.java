package mow.it.now.test;
import static org.junit.Assert.*;

import org.junit.Test;

import mow.it.now.logic.Lawn;

public class PelouseTest {

	@Test
	public void isValidTest() {
		Lawn pelouse = new Lawn(3,2);
		assertTrue("The position should be valid", pelouse.isValid(0, 0));
		assertTrue("The position should be valid", pelouse.isValid(2, 0));
		assertTrue("The position should be valid", pelouse.isValid(2, 1));
		assertFalse("The position should not be valid", pelouse.isValid(3, 2));
		assertFalse("The position should not be valid", pelouse.isValid(2, 3));
		assertFalse("The position should not be valid", pelouse.isValid(0, -1));
		assertFalse("The position should not be valid", pelouse.isValid(-1, -1));
		assertFalse("The position should not be valid", pelouse.isValid(-1, 0));
	}
}
