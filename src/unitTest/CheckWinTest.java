package unitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import patterns.PatternLookUp;
import payTable.RewardLookUp;
import winnings.CheckWin;

class CheckWinTest {

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void test() throws IOException{
		String filePath = "C:\\Users\\Gary\\eclipse-workspace\\ReelEmulation\\Paytable.txt";
		RewardLookUp rlu = new RewardLookUp(filePath);
		String filePath2 = "C:\\Users\\Gary\\eclipse-workspace\\ReelEmulation\\patterns.txt";
		PatternLookUp plu = new PatternLookUp(filePath2);
		String symbols[][] = {
				{"K","K","K","A","A"},
				{"K","Q","Q","Q","Q"},
				{"A","A","A","A","J"}
		};
		CheckWin cw = new CheckWin(symbols);
		double result = cw.calculateWin(rlu, plu);
		assertEquals(5, result);
	}
	
	@Test
	void negativeTest() throws IOException{
		String filePath = "C:\\Users\\Gary\\eclipse-workspace\\ReelEmulation\\Paytable.txt";
		RewardLookUp rlu = new RewardLookUp(filePath);
		String filePath2 = "C:\\Users\\Gary\\eclipse-workspace\\ReelEmulation\\patterns.txt";
		PatternLookUp plu = new PatternLookUp(filePath2);
		String symbols[][] = {
				{"J","K","K","K","K"},
				{"Q","Q","Q","Q","Q"},
				{"A","A","A","A","A"}
		};
		CheckWin cw = new CheckWin(symbols);
		double result = cw.calculateWin(rlu, plu);
		assertEquals(0, result);
	}
	
	@Test
	void negativeTest2() throws IOException{
		String filePath = "C:\\Users\\Gary\\eclipse-workspace\\ReelEmulation\\Paytable.txt";
		RewardLookUp rlu = new RewardLookUp(filePath);
		String filePath2 = "C:\\Users\\Gary\\eclipse-workspace\\ReelEmulation\\patterns.txt";
		PatternLookUp plu = new PatternLookUp(filePath2);
		String symbols[][] = {
				{"9","10","J","Q","K"},
				{"9","10","J","Q","K"},
				{"9","10","J","Q","K"}
		};
		CheckWin cw = new CheckWin(symbols);
		double result = cw.calculateWin(rlu, plu);
		assertEquals(0, result);
	}
	
}
