/*
	Question 3: Program that generates a random month
	Sources: JAVA API

*/

import java.util.Random;

public class RandomMonth{
	public static void main(String[] args){
		Random rnd = new Random();
		int month = rnd.nextInt(11) + 1;
		
		switch(month){
			case 1: System.out.printf("January from number %d%n", month);
					break;
			case 2: System.out.printf("February from number %d%n", month);
					break;		
			case 3: System.out.printf("March from number %d%n", month);
					break;
			case 4: System.out.printf("April from number %d%n", month);
					break;
			case 5: System.out.printf("May from number %d%n", month);
					break;
			case 6: System.out.printf("June from number %d%n", month);
					break;
			case 7: System.out.printf("July from number %d%n", month);
					break;
			case 8: System.out.printf("August from number %d%n", month);
					break;
			case 9: System.out.printf("September from number %d%n", month);
					break;
			case 10: System.out.printf("October from number %d%n", month);
					break;
			case 11: System.out.printf("November from number %d%n", month);
					break;		
			case 12: System.out.printf("December from number %d%n", month);
		}
	}
}