package unitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import patterns.Pattern;
import patterns.PatternMatch;

//class Pattern
class FindMatchTest {

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void test() {
		String symbols[][] = {
				{"K","K","K","A","A"},
				{"K","Q","Q","Q","Q"},
				{"A","A","A","A","J"}
		};
		List<String> lines = new ArrayList<>();
		lines.add("XXXXX");
		lines.add("-----");
		lines.add("-----");
		Pattern p = new Pattern(lines);
		PatternMatch pm = p.findMatch(symbols);
		assertEquals("K", pm.getSymbol());
		assertEquals(3, pm.getQuantity());
	}

	@Test
	void negativetest() {
		String symbols[][] = {
				{"J","J","K","A","A"},
				{"K","Q","Q","Q","Q"},
				{"A","A","A","A","J"}
		};
		List<String> lines = new ArrayList<>();
		lines.add("XXXXX");
		lines.add("-----");
		lines.add("-----");
		Pattern p = new Pattern(lines);
		PatternMatch pm = p.findMatch(symbols);
		assertNotEquals("K", pm.getSymbol());
	}
}
