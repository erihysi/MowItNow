package mow.it.now.parsing;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import mow.it.now.logic.*;

public class MowParserUtil {
	
	
	public static MowExecutor parseInformationFromStream(InputStream inputStream) {	
		MowExecutor executor = null;	
		try (Scanner scanner =  new Scanner(inputStream)){
			executor = ReadFromScanner( scanner);      
		} catch (IOException e) {
			System.out.println("Error while scanning data");
			System.out.println("Error detail :" + e.getMessage());
		}
		return executor;
	}

	public static MowExecutor ReadFromScanner(Scanner scanner)
			throws IOException {
		MowExecutor executor = null;
		List<Mower> mowers = new ArrayList<Mower>();
		Lawn lawn = ReadLawnInfo(scanner.nextLine());		
		while (scanner.hasNextLine()){
			String positionLine = scanner.nextLine();
			if(!scanner.hasNextLine())
			{
				throw new IOException("Data is missing instruction information");
			}
			String instructionLine = scanner.nextLine();
			Mower t = ReadMowerInfo(positionLine,instructionLine);
			mowers.add(t);
			executor = new MowExecutor(lawn, mowers);
		}
		return executor;
	}

	public static Mower ReadMowerInfo(String positionLine, String instructionLine) throws IOException {
		Position position = null;
		Direction direction = null;
		try (Scanner scanner = new Scanner(positionLine))
		{
		    scanner.useDelimiter(" ");
		    if (scanner.hasNext()){
		      int x = scanner.nextInt();
		      if(!scanner.hasNext())
		    	  throw new IOException("Invalid line. Unable to process.");
		      int y = scanner.nextInt();
		      position = new Position(x, y);
		      direction = Direction.Parse(scanner.next());
		    }
		    else {
		      throw new IOException("Empty line. Unable to process.");
		    }
		}
	    
	    List<Instruction> instructions = new ArrayList<Instruction>();
	    String instruction = instructionLine.trim();
	    for(int i = 0 ; i< instruction.length(); i++)
	    {
	    	instructions.add(
	    			Instruction.Parse(
	    					String.valueOf(instruction.charAt(i))));  
	    }
	    return new Mower(position, direction, instructions);
	}

	public static Lawn ReadLawnInfo(String line) throws IOException {
		Lawn lawn = null;
		try (Scanner scanner = new Scanner(line))
		{
		    scanner.useDelimiter(" ");
		    if (scanner.hasNext()){
		      int x = scanner.nextInt();
		      if(!scanner.hasNext())
		    	  throw new IOException("Invalid line. Unable to process.");
		      int y = scanner.nextInt();
		      lawn = new Lawn(x + 1,y + 1);
		    }
		    else {
		      throw new IOException("Empty line. Unable to process.");
		    }
		}
		return lawn;
	}
	
}
