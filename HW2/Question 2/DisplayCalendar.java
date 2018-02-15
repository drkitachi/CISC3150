/*
	Question 2: Display all the calendars of a certain year.
	Resources: http://eilat.sci.brooklyn.cuny.edu/cisc1115/handouts/IsLeap.java
	Professor's Langsam sample program to figure out a leap year.

*/

import java.util.*;

public class DisplayCalendar{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int year, day;
		
		System.out.print("Enter the year to display the calendar: ");
		year = input.nextInt();
		
		day = numberDate();
		
		printCalendar(year,day);
	}
	
	public static void printCalendar(int year, int day){
		ArrayList<String> month = getMonths();
		ArrayList<Integer> daysInMonth = getDays(year);
		int counter;
		
		String width, spacing = "   ";
		
		for(int i = 0; i < 12; i++){
			if(day == 0)
				day = 7;
			counter = day;
			width = "%2d ";
			
			System.out.printf("%n%11s %d%n", month.get(i), year);
			System.out.println("Mo Tu We Th Fr Sa Su");
			
			for(int j= 1; j < day; j++)
				System.out.print(spacing);
			for(int days = 1; days <= daysInMonth.get(i); days++){
				if(days > 9)
					width = "%d ";
				System.out.printf(width, days);
				
				if(counter % 7 == 0)
					System.out.println();
				counter++;
			}
			System.out.println();
			day = (day+daysInMonth.get(i)) % 7;
		}
	}
			
		
	
	public static int numberDate(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the date of the first of January of this year (lower case): ");
		String date = scan.next();
		switch(date){
			case "monday" : return 1;
			case "tuesday" : return 2;
			case "wednesday" : return 3;
			case "thursday" : return 4;
			case "friday" : return 5;
			case "saturday" : return 6;
			case "sunday" : return 7;
		}
		return 0;
	}
	
	public static ArrayList<String> getMonths(){
		ArrayList<String> months = new ArrayList<String>(
									Arrays.asList("January", "February", "March", "April", "May", "June", "July",
													"August", "September", "October", "November", "December"));
		
		return months;
	}
	
	public static ArrayList<Integer> getDays(int year){
		ArrayList<Integer> datesInMonth = new ArrayList<Integer>();
		
		if(isLeapYear(year)){
			datesInMonth.add(31);
			datesInMonth.add(29);
			datesInMonth.add(31);
			datesInMonth.add(30);
			datesInMonth.add(31);
			datesInMonth.add(30);
			datesInMonth.add(31);
			datesInMonth.add(31);
			datesInMonth.add(30);
			datesInMonth.add(31);
			datesInMonth.add(30);
			datesInMonth.add(31);
		} else {
			datesInMonth.add(31);
			datesInMonth.add(28);
			datesInMonth.add(31);
			datesInMonth.add(30);
			datesInMonth.add(31);
			datesInMonth.add(30);
			datesInMonth.add(31);
			datesInMonth.add(31);
			datesInMonth.add(30);
			datesInMonth.add(31);
			datesInMonth.add(30);
			datesInMonth.add(31);
		}
		
		return datesInMonth;
	}
							
	public static boolean isLeapYear(int year){
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
	
}