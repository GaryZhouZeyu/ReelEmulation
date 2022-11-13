package unitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import patterns.Pattern;
import patterns.PatternLookUp;
import patterns.PatternMatch;

class PatternLookUpTest {

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void test() throws IOException{
		PatternLookUp plu = new PatternLookUp("patterns.txt");
		String symbols[][] = {
				{"J","K","K","J","J"},
				{"K","Q","Q","K","Q"},
				{"A","A","A","A","K"}
		};
		List<PatternMatch> matches;
		matches = plu.findMatchPatternCombinations(symbols);
		assertEquals(1, matches.size());
		
		
	}
	
	@Test
	void testSpecialPattern() throws IOException{
		PatternLookUp plu = new PatternLookUp("patterns.txt");
		String symbols[][] = {
				{"K","A","K","A","K"},
				{"Q","K","K","K","Q"},
				{"K","A","A","A","K"}
		};
		List<PatternMatch> matches;
		matches = plu.findMatchPatternCombinations(symbols);
		assertEquals(1, matches.size());
		String symbol = matches.get(0).getSymbol();
		assertEquals("Q", symbol);
		int quantity = matches.get(0).getQuantity();
		assertEquals(1, quantity);
	}

}
