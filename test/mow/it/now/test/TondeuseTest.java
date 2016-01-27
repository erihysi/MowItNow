package mow.it.now.test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import mow.it.now.logic.Direction;
import mow.it.now.logic.Instruction;
import mow.it.now.logic.Lawn;
import mow.it.now.logic.Position;
import mow.it.now.logic.Mower;

public class TondeuseTest {
	
	@Test
	public void testRunProgram1() {
		List<Instruction> instructions = new ArrayList<Instruction>();
		instructions.add(Instruction.LEFT);
		instructions.add(Instruction.FORWARD);
		instructions.add(Instruction.LEFT);
		instructions.add(Instruction.FORWARD);
		instructions.add(Instruction.LEFT);
		instructions.add(Instruction.FORWARD);
		instructions.add(Instruction.LEFT);
		instructions.add(Instruction.FORWARD);
		instructions.add(Instruction.FORWARD);
		testFinalPosition(new Lawn(6,6),new Position(1, 2), Direction.NORTH, instructions, 1, 3, Direction.NORTH);
	}
	
	@Test
	public void testRunProgram2() {
		List<Instruction> instructions = new ArrayList<Instruction>();
		instructions.add(Instruction.FORWARD);
		instructions.add(Instruction.FORWARD);
		instructions.add(Instruction.RIGHT);
		instructions.add(Instruction.FORWARD);
		instructions.add(Instruction.FORWARD);
		instructions.add(Instruction.RIGHT);
		instructions.add(Instruction.FORWARD);
		instructions.add(Instruction.RIGHT);
		instructions.add(Instruction.RIGHT);
		instructions.add(Instruction.FORWARD);
		testFinalPosition(new Lawn(6,6),new Position(3, 3), Direction.EAST, instructions, 5, 1, Direction.EAST);
	}

	private void testFinalPosition(Lawn lawn, Position pos, Direction direction, List<Instruction> instructions, int expectedX, int expectedY, Direction expectedD) {
		Mower t = new Mower(pos, direction, instructions );
		t.RunProgram(lawn);
		Position position = t.getPosition();
		Direction dir = t.getDirection();
		assertEquals("Wrong final position after executing the instructions", 
				expectedX,position.getX());
		assertEquals("Wrong final position after executing the instructions", 
				expectedY,position.getY());
		assertEquals("Wrong final direction after executing the instructions", 
				expectedD, dir);
	}

}
