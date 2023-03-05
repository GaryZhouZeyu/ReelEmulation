package reels;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SymbolLookUp {
	private String[][] reels;
	public SymbolLookUp(InputStream fileInput) throws IOException{
		ReadReelInfo(fileInput);
	}
	private void ReadReelInfo(InputStream fileInput) throws IOException{
		
		// count row column length of reel strips
        BufferedReader br = new BufferedReader(new InputStreamReader(fileInput));
        String st;
        int symbolCount = 0, reelCount = 0;
        List<String> lines = new ArrayList<>();
        while ((st = br.readLine()) != null) {
        	lines.add(st);
        	StringTokenizer tok = new StringTokenizer(st); 
        	reelCount = tok.countTokens();
		    symbolCount++;
    	}
        reels = new String[symbolCount][reelCount];
        //br.close();
        
        // Read elements into 2d array
        int symbolNumber = 0, reelNumber = 0;
        for(String thisLine:lines){
        	StringTokenizer tok = new StringTokenizer(thisLine);  
		        while (tok.hasMoreTokens()) {  
		            reels[symbolNumber][reelNumber] = tok.nextToken();
		            reelNumber++;
		        }  
		        reelNumber = 0;
		        symbolNumber++;
    	}
        
        for(int i = 0; i < symbolCount; i++) {
        	for (int j = 0 ; j < reelCount; j++) {
        		System.out.print(reels[i][j]);
        	}
        	System.out.println();
        }
	}
	public String findSymbol(int symbolNumber, int reelNumber) {
		return reels[symbolNumber][reelNumber];
	}
	
	/**
	 *  
	 * @param middleIndices a set of indexes pointing to the middle row of a set of symbols -
	 * @return a set of symbols (user roll) with the corresponding symbols in the middle row, and the adjacent symobls above and below
	 */
	public String[][] constructSymbolsFromMiddleIndices(int[] middleIndices) {
		String[][] symbols = new String[3][5];
		for(int i = 0; i < symbols.length; i++) {
			symbols[i] = new String[5];
		}
		for(int i = 0; i < middleIndices.length; i++) {
			int tempIndex = middleIndices[i];
			//up
			int upIndex = tempIndex-1;
			if(upIndex == -1) {
				upIndex = reels.length-1;
			}
			//down
			int downIndex = tempIndex+1;
			if(downIndex == reels.length) {
				downIndex = 0;
			}
			symbols[0][i] = reels[upIndex][i];
			symbols[1][i] = reels[tempIndex][i];
			symbols[2][i] = reels[downIndex][i];
		}
		return symbols;	
	}
}
