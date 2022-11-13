package unitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import patterns.PatternMatch;
import payTable.Reward;
import payTable.RewardLookUp;

class RewardLookUpTest {

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void test() throws IOException{
		String filePath = "C:\\Users\\Gary\\eclipse-workspace\\ReelEmulation\\Paytable.txt";
		RewardLookUp rlu = new RewardLookUp(filePath);
		
		List<PatternMatch> patternMatches = new ArrayList<PatternMatch>();
		patternMatches.add(new PatternMatch("Q", 3));
		patternMatches.add(new PatternMatch("Q", 4));
		patternMatches.add(new PatternMatch("Q", 5));
		List<Reward> matchingRewards = rlu.findRewardCombinations(patternMatches);
		assertEquals(3, matchingRewards.size());
	}

	@Test
	void testFindHighests() throws IOException{
		String filePath = "C:\\Users\\Gary\\eclipse-workspace\\ReelEmulation\\Paytable.txt";
		RewardLookUp rlu = new RewardLookUp(filePath);
		List<PatternMatch> patternMatches = new ArrayList<PatternMatch>();
		patternMatches.add(new PatternMatch("Q", 3));
		patternMatches.add(new PatternMatch("Q", 4));
		patternMatches.add(new PatternMatch("Q", 5));
		List<Reward> matchingRewards = rlu.findRewardCombinations(patternMatches);
		
		Reward highest = rlu.findHighestReward(matchingRewards);
		assertEquals("Q", highest.getSymbol());
		assertEquals(4, highest.getAmount());
	}
	
	@Test
	void testFindHighestsNoReward() throws IOException{
		String filePath = "C:\\Users\\Gary\\eclipse-workspace\\ReelEmulation\\Paytable.txt";
		RewardLookUp rlu = new RewardLookUp(filePath);
		List<PatternMatch> patternMatches = new ArrayList<PatternMatch>();
		patternMatches.add(new PatternMatch("J", 3));
		patternMatches.add(new PatternMatch("J", 4));
		patternMatches.add(new PatternMatch("J", 5));
		List<Reward> matchingRewards = rlu.findRewardCombinations(patternMatches);
		
		Reward highest = rlu.findHighestReward(matchingRewards);
		assertNull(highest);
	}
}
