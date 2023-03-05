package UserInput;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
		InputStream fileInputStream = new FileInputStream("resources\\Reels.txt");
		SymbolLookUp slu = new SymbolLookUp(fileInputStream);
		int[] indices = userInput();
		String[][] symbols = slu.constructSymbolsFromMiddleIndices(indices);
		printMatrix(symbols);
		InputStream fileInputStream1 = new FileInputStream("resources\\Paytable.txt");
		RewardLookUp rlu = new RewardLookUp(fileInputStream1);
		InputStream fileInputStream2 = new FileInputStream("resources\\patterns.txt");
		PatternLookUp plu = new PatternLookUp(fileInputStream2);
		CheckWin cw = new CheckWin(symbols);
		double result = cw.calculateWin(rlu, plu);
		System.out.println("win = " + result);
	}
}
