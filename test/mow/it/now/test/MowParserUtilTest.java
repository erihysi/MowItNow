package mow.it.now.test;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.junit.Test;

import mow.it.now.logic.Direction;
import mow.it.now.logic.MowExecutor;
import mow.it.now.parsing.MowParserUtil;;
public class MowParserUtilTest {

	@Test
	public void parseInformationFromStreamTest()
	{
		URL url = this.getClass().getResource("/TestFile");
		File file = new File(url.getFile());
		try(InputStream stream = new FileInputStream(file))
		{
			MowExecutor executor = MowParserUtil.parseInformationFromStream(stream);
			assertEquals(6,executor.getPelouse().getHeight());
			assertEquals(6,executor.getPelouse().getWidth());
			assertEquals(Direction.NORTH,executor.getTondeuses().get(0).getDirection());
			assertEquals(Direction.EAST,executor.getTondeuses().get(1).getDirection());
			assertEquals(1,executor.getTondeuses().get(0).getPosition().getX());
			assertEquals(2,executor.getTondeuses().get(0).getPosition().getY());
			assertEquals(3,executor.getTondeuses().get(1).getPosition().getX());
			assertEquals(3,executor.getTondeuses().get(1).getPosition().getY());
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
}
