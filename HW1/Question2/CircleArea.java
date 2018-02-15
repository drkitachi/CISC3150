/*
	Question 2: Calculate areas with user's input of radius.

*/

import java.util.Scanner;

public class CircleArea{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		double radius, areaOfCircle;
		
		while(input.hasNext()){
			radius = input.nextDouble();
			areaOfCircle = Math.pow(radius, 2) * Math.PI;
			System.out.printf("Radius: %f   Area: %f%n", radius, areaOfCircle);
		}
	}
}