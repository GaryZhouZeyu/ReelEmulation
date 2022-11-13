package payTable;

import patterns.PatternMatch;

public class Reward {
	private double amount = 0;
	private String symbol;
	private int count = 0;
	public Reward(double amount, String symbol, int count) {
		this.amount = amount;
		this.symbol = symbol;
		this.count = count;
	}
	public boolean meetRequirements(String[][] symbols) {
		int matchCount = 0;
		for(int reelNumber = 0; reelNumber < symbols[0].length; reelNumber++) {
			boolean containSymbol = false;			
			for(int symbolNumber = 0; symbolNumber < symbols.length; symbolNumber++) {
				if(symbols[symbolNumber][reelNumber].equals(symbol)) {// if contains the required symbol in this location
					containSymbol = true;
				}
			}
			if(containSymbol) {
				matchCount++;
			}else {
				break; //break outer for loop
			}
		}
		return matchCount >= count;
	}
	public double getAmount() {
		return amount;
	}
	public String getSymbol() {
		return symbol;
	}
	public int getCount() {
		return count;
	}
	public boolean ifRewardMatchPatternMatch(PatternMatch thisPattern) {
		return thisPattern.getQuantity() == this.getCount() && thisPattern.getSymbol().equals(this.getSymbol());
	}
	
}
