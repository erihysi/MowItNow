package mow.it.now;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import mow.it.now.logic.*;
import mow.it.now.parsing.MowParserUtil;

public class MowItNow {

	public static void main(String[] args) {
		
		MowExecutor executor = null;
		try(InputStream stream = args.length == 1 ? new FileInputStream(args[0]) : System.in)
		{
			executor = MowParserUtil.parseInformationFromStream(stream);
		} catch (FileNotFoundException e) {
			System.out.println("Error while retrieving input file");
		} catch (IOException e) {
			System.out.println("Error while parsing input data");
		}

		if(executor == null)
			return;
		
		executor.Run();
	}

	

}
