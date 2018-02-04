/*
	Question 4: Read file with numbers from command line and print them out in the screen
	On the terminal: java ReadFileFromCMD <fileInputForCMD.txt
*/

import java.util.Scanner;

public class ReadFileFromCMD{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		double number;
		
		while(scan.hasNext()){
			number = scan.nextDouble();
			System.out.println(number);
		}
	}
}
			
	
	