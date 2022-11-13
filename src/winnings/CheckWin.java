package winnings;

import java.util.List;
import java.util.Set;

import patterns.Pattern;
import patterns.PatternLookUp;
import patterns.PatternMatch;
import payTable.Reward;
import payTable.RewardLookUp;

public class CheckWin {
	private String symbols[][];
	public CheckWin(String[][] symbols) {
		this.symbols = symbols;
	}
	public double calculateWin(RewardLookUp rlu, PatternLookUp plu) {
		List<PatternMatch> patternMatch = plu.findMatchPatternCombinations(symbols);
		List<Reward> matchingRewards = rlu.findRewardCombinations(patternMatch);
		double sumWin = 0; 
		for(int thisMatchingReward = 0; thisMatchingReward<matchingRewards.size(); thisMatchingReward++) {
			if(matchingRewards.get(thisMatchingReward)!=null) {
				sumWin += matchingRewards.get(thisMatchingReward).getAmount();
				System.out.println(sumWin);	
			}
		}
		return sumWin;
	}
}
