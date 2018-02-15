/*
	Question 5: Change the delimitter to comma separated token.
	
*/

import java.util.Scanner;

public class ComaScanner{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String s;
		scan.useDelimiter(",+");
		
		while(scan.hasNext()){
		s = scan.next();
		System.out.println(s);
		}
	}
}

