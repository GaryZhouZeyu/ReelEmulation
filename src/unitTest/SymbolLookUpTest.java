package unitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import reels.SymbolLookUp;

class SymbolLookUpTest {

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void test() throws IOException{
		String filePath = "C:\\Users\\Gary\\eclipse-workspace\\ReelEmulation\\Reels.txt";
		SymbolLookUp slu = new SymbolLookUp(filePath);
		String symbol = slu.findSymbol(0, 0);
		assertEquals("A", symbol);
		
	}
	
	@Test
	void testConstructSymbolsFromMiddleIndices() throws IOException{
		String filePath = "C:\\Users\\Gary\\eclipse-workspace\\ReelEmulation\\Reels.txt";
		SymbolLookUp slu = new SymbolLookUp(filePath);
		int[] indices = {1,2,3,4,5};
		String[][] symbols = slu.constructSymbolsFromMiddleIndices(indices);
		assertEquals(3, symbols.length);
		assertEquals(5, symbols[0].length);
		assertEquals(5, symbols[1].length);
		assertEquals(5, symbols[2].length);
		assertEquals("A", symbols[0][0]);
	}

}
