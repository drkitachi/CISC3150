/*
	
	Question 1: Print a triangle from a maximum input number.
	Resources: https://stackoverflow.com/questions/2550123/java-printf-using-variable-field-size
	Using a String for the format of my integer width.

*/

import java.util.Scanner;

public class TriangleTree{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int max, width, j;
		String s;
		
		System.out.print("What's the max size of the triangle?");
		max = input.nextInt();
		System.out.printf(" %d%n", max);
	
		width = max*2+1;
		
		for(int i = 1; i <= max; i++){
			width=width-2;
			s = "%" + width + "d";
			j = 1;
			System.out.printf(s, j);
			if(i == 1) {
				System.out.println();
				continue;
			}
			for(j = 2; j < i; j++)
				System.out.printf(" %d", j);
			for(j = j; j > 0; j--)
				System.out.printf(" %d", j);
			System.out.println();
		}
	}
}