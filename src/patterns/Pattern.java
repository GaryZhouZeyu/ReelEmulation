package patterns;

import java.util.List;

public class Pattern {
	private boolean pattern[][];
	public static final int REELNUM = 5;
	public Pattern(List<String> patternLines){
		//read pattern text
		pattern = new boolean[patternLines.size()][];
		for(int row = 0; row < patternLines.size(); row++) {
			pattern[row] = new boolean[REELNUM];
			for(int reelNum = 0; reelNum < REELNUM; reelNum++) {
				String currentLine = patternLines.get(row);
				char symbol = currentLine.charAt(reelNum);
				pattern[row][reelNum] = (symbol == 'x' || symbol == 'X');				
			}
		}
	}
	//returns null if no match found
	public PatternMatch findMatch(String[][] symbols) {
		String thisSymbol;
		PatternMatch match = null;
		//find the left-most match
		for (int row = 0; row < pattern.length; row++) {
			if (pattern[row][0]) {
				match = new PatternMatch(symbols[row][0], 1);
			}
		}
		if (match != null) {
			for(int reelNum = 1; reelNum < REELNUM; reelNum++) {
				//does this column have a required
				for (int row = 0; row < pattern.length; row++) {
					if (pattern[row][reelNum]) {
						if (symbols[row][reelNum].equals(match.getSymbol())){ 
							match.setQuantity(match.getQuantity() +1);
						} else {
							return match;
						}
						
					} 
				}
			}
		}
		return match;
	}
	public int countMatches(String[][] symbols, String thisSymbol) {
		int matchCount = 0;
		for(int row = 0; row < pattern.length; row++) {
			for(int reelNum = 0; reelNum < REELNUM; reelNum++) {
				if(pattern[row][reelNum]) {
					if(symbols[row][reelNum].equals(thisSymbol)) {
						matchCount++;
					}else {
						break; //start from left, continue without breaking
					}
				}
			}
		}
		return matchCount;
	}
	
	public int findMatchCount(String[][] symbols, String thisSymbol) {
		int matchCount = countMatches(symbols,thisSymbol);
		return  matchCount;
	}
	
}
