package patterns;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import payTable.Reward;

public class PatternLookUp {
	private List<Pattern> patterns;
	

	public PatternLookUp(String file) throws IOException{//read paytable
		patterns = new ArrayList<Pattern>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int i=0;
        while ((st = br.readLine()) != null) {
        	List<String> lines = new ArrayList<>();
        	while (st != null && st.trim().length() > 0) {
	        	lines.add(st);
	        	st  = br.readLine();	        	
			}
        	Pattern p = new Pattern(lines);
		    patterns.add(p);
    	}
	}
	/**
	 * Returns a list of patternMatches
	 * Each element is a patternMatche or null corresponding to the same pattern.
	 * For example if there are 3 patterns
	 * p1 
	 * null
	 * p3
	 */
	public List<PatternMatch> findMatchPatternCombinations(String[][] symbols){
		
		List<PatternMatch> matchingPatterns = new ArrayList<PatternMatch>();				
		for(Pattern currentPattern: patterns) {
			PatternMatch match = currentPattern.findMatch(symbols);
			matchingPatterns.add(match);
				
		}
		return matchingPatterns;
	}
	public List<Pattern> getPatterns() {
		return patterns;
	}

	/*
	 * 		List<Pattern> matchingPatterns = new ArrayList<Pattern>();
		for(int i = 0; i < patterns.size(); i++) {
			Pattern currentPattern = patterns.get(i);
			if(currentPattern.meetsRequirements(symbols, thisSymbol)) {
				matchingPatterns.add(currentPattern);
			}
		}
		return matchingPatterns;
	 */
}
