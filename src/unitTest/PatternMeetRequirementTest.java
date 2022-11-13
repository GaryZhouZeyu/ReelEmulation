package unitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import patterns.Pattern;

class PatternMeetRequirementTest {

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void test() {
		List<String> lines = new ArrayList<>();
		lines.add("XXXXX");
		lines.add("-----");
		lines.add("-----");
		Pattern p = new Pattern(lines);
		String symbols[][] = {
				{"K","K","K","A","A"},
				{"Q","Q","Q","Q","Q"},
				{"A","A","A","A","J"}
		};
		String thisSymbol = "K";
		int test1 = p.countMatches(symbols, thisSymbol);
		assertEquals(3, test1);;
		
		int test2 = p.findMatchCount(symbols, thisSymbol);
		assertEquals(3, test2);
		
	}
	
	@Test
	void testNegative() {
		List<String> lines = new ArrayList<>();
		lines.add("XXXXX");
		lines.add("-----");
		lines.add("-----");
		Pattern p = new Pattern(lines);
		String symbols[][] = {
				{"K","K","K","A","A"},
				{"Q","Q","Q","K","Q"},
				{"A","A","A","A","K"}
		};
		String thisSymbol = "2";
		int test1 = p.countMatches(symbols, thisSymbol);
		assertEquals(0, test1);
		
		
		
		int test2 = p.findMatchCount(symbols, thisSymbol);
		assertEquals(0, test2);
		
	}
	
	
}
