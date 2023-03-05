package unitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

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
		InputStream fileInputStream = new FileInputStream("C:\\Users\\Gary\\eclipse-workspace\\ReelEmulation\\resources\\Paytable.txt");
		RewardLookUp rlu = new RewardLookUp(fileInputStream);
		InputStream fileInputStream2 = new FileInputStream("C:\\Users\\Gary\\eclipse-workspace\\ReelEmulation\\resources\\patterns.txt");
		PatternLookUp plu = new PatternLookUp(fileInputStream2);
		String symbols[][] = {
				{"K","K","K","A","A"},
				{"K","Q","Q","Q","Q"},
				{"A","A","A","A","J"}
		};
		CheckWin cw = new CheckWin(symbols);
		double result = cw.calculateWin(rlu, plu);
		assertEquals(10, result);
	}
	
	@Test
	void negativeTest() throws IOException{
		InputStream fileInputStream = new FileInputStream("C:\\Users\\Gary\\eclipse-workspace\\ReelEmulation\\resources\\Paytable.txt");
		RewardLookUp rlu = new RewardLookUp(fileInputStream);
		InputStream fileInputStream2 = new FileInputStream("C:\\Users\\Gary\\eclipse-workspace\\ReelEmulation\\resources\\patterns.txt");
		PatternLookUp plu = new PatternLookUp(fileInputStream2);
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
		InputStream fileInputStream = new FileInputStream("C:\\Users\\Gary\\eclipse-workspace\\ReelEmulation\\resources\\Paytable.txt");
		RewardLookUp rlu = new RewardLookUp(fileInputStream);
		InputStream fileInputStream2 = new FileInputStream("C:\\Users\\Gary\\eclipse-workspace\\ReelEmulation\\resources\\patterns.txt");
		PatternLookUp plu = new PatternLookUp(fileInputStream2);
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
