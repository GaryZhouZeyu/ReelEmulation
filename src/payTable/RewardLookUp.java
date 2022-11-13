package payTable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import patterns.Pattern;
import patterns.PatternMatch;

public class RewardLookUp {
	private List<Reward> rewards;
	public RewardLookUp(String file) throws IOException{//read paytable
		rewards = new ArrayList<Reward>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;double pay=0;
        while ((st = br.readLine()) != null) {
        	if (st.trim().length() > 0) {
	        	StringTokenizer tok = new StringTokenizer(st);  
	        	String[] symbols = new String[tok.countTokens()-1];
	        	int symbolIndex = 0;
			        while (tok.hasMoreTokens()) {  
			        	if(symbolIndex == symbols.length) {//last symbol
			        		String token = tok.nextToken();
			        		pay = Double.parseDouble(token);
			        	}else {
				        	String token = tok.nextToken();
				        	symbols[symbolIndex] = token;
				        	symbolIndex++;
			        	}
			        }  
			     Reward reward = new Reward(pay,symbols[0],symbols.length);
			     rewards.add(reward);
			}
    	}
	}
	
	
	
	//
	//
	public List<Reward> findRewardCombinations(List<PatternMatch> patternMatches){
		List<Reward> matchingRewards = new ArrayList<Reward>();
		for(int patternIndex = 0; patternIndex < patternMatches.size(); patternIndex++) {
			PatternMatch thisPattern = patternMatches.get(patternIndex);
			for(int rewardIndex = 0; rewardIndex < rewards.size(); rewardIndex++) {
				Reward thisReward = rewards.get(rewardIndex);
				if(thisReward.ifRewardMatchPatternMatch(thisPattern)) {
					matchingRewards.add(thisReward);
				}
			}
		}
		return matchingRewards;
	}
	
	//if list empty, return null
	public Reward findHighestReward(List<Reward> matchingRewards) {
		Reward highest = null;
		if(matchingRewards.size()!=0) {
			highest = matchingRewards.get(0);
			for(Reward reward:matchingRewards) {
				if(reward.getAmount() > highest.getAmount()) {
					highest = reward;
				}
			}
		}
		return highest;
	}
	
}
