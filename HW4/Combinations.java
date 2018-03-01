/*
	Program that prints all combinations of a 2D character array, it uses 2 arrayList, one holds the combinations as it
	starts forming from array to array and one is used to build up the combinations.
*/

import java.util.*;

public class Combinations{
	public static void main(String[] args){
		
		int c=0, rowSize, colSize;
		String sb;
		Scanner scan = new Scanner(System.in);
		ArrayList<String> combinationArray = new ArrayList<String>();
		ArrayList<String> combinationBuilder = new ArrayList<String>();
		
		rowSize = scan.nextInt();
		char[][] chars = new char[rowSize][];
		
		for(int i = 0; i < chars.length; i++){
			colSize = scan.nextInt();
			chars[i] = new char[colSize];
			for(int j = 0; j < chars[i].length; j++)
				chars[i][j] = scan.next().charAt(0);
		}
		
		for(char d: chars[c]){
			sb = String.valueOf(d);
			combinationArray.add(sb);
		}
		
		c++;

		for(; c < chars.length; c++){
			for(String t: combinationArray){
				for(int i = 0; i < chars[c].length; i++)
					combinationBuilder.add(t + chars[c][i]);
			}
			
			combinationArray.clear();
			
			for(String v: combinationBuilder)
				combinationArray.add(v);
			
			combinationBuilder.clear();
		}	
		
		System.out.println("\nAll possible combinations are: ");
		
		for(String s: combinationArray)
			System.out.println(s);
	}
}