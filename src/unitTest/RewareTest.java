package unitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import payTable.Reward;

class RewareTest {

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void Postest() {
		String[][] symbols = {
			{"K","Q","K","K","A"},
			{"Q","K","Q","Q","Q"},
			{"A","A","A","A","A"}
		};
		String[] combination= {"K","K","K","K"};
		Reward r = new Reward(10,combination[0],combination.length);
		boolean condition = r.meetRequirements(symbols);
		assertTrue(condition);
		
	}

	@Test
	void Negtest() {
		String[][] symbols = {
				{"K","K","K","A","A"},
				{"Q","Q","Q","Q","Q"},
				{"A","A","A","A","A"}
			};
		String[] combination= {"K","K","K","K"};
		Reward r = new Reward(10,combination[0],combination.length);
		
		boolean condition = r.meetRequirements(symbols);
		assertFalse(condition);
	}
	
}
