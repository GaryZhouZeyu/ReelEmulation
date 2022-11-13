package UserInput;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

import patterns.PatternLookUp;
import payTable.RewardLookUp;
import reels.SymbolLookUp;
import winnings.CheckWin;

public class InputDriver {

	public static int[] userInput() {
		System.out.println("Please enter the indexes : ");
		Scanner input = new Scanner(System.in);
		String indexString = input.nextLine();
		StringTokenizer st = new StringTokenizer(indexString);
		int[]indices = new int[st.countTokens()-1];
		st.nextToken();//expect a 5r in the beginning of line
		int i = 0;
		while(st.hasMoreTokens()) {
			indices[i] = Integer.parseInt(st.nextToken());
			i++;
		}
		return indices;
	}
	public static void printMatrix(String[][]symbols) {
		for(int row = 0; row < symbols.length; row++) {
			for(int reel = 0; reel < symbols[row].length; reel++) {
				System.out.print(symbols[row][reel]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) throws IOException{
		String filePath = "C:\\Users\\Gary\\eclipse-workspace\\ReelEmulation\\Reels.txt";
		SymbolLookUp slu = new SymbolLookUp(filePath);
		int[] indices = userInput();
		String[][] symbols = slu.constructSymbolsFromMiddleIndices(indices);
		printMatrix(symbols);
		String filePath1 = "C:\\Users\\Gary\\eclipse-workspace\\ReelEmulation\\Paytable.txt";
		RewardLookUp rlu = new RewardLookUp(filePath1);
		String filePath2 = "C:\\Users\\Gary\\eclipse-workspace\\ReelEmulation\\patterns.txt";
		PatternLookUp plu = new PatternLookUp(filePath2);
		CheckWin cw = new CheckWin(symbols);
		double result = cw.calculateWin(rlu, plu);
		System.out.println("win = " + result);
	}
}
