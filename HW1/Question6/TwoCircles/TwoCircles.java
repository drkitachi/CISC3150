package TwoCircles;

import java.util.Scanner;
import TwoCircles.Circle;

public class TwoCircles{
	private Circle circle1;
	private Circle circle2;
	private double distance;
	private Scanner input;
	
	public TwoCircles(){
		this.circle1 = new Circle();
		this.circle2 = new Circle();
	}
		
	public void run(){
		input = new Scanner(System.in);
		
		System.out.println("Enter the coordinates x and y of the center of circle 1 and the radius");
		circle1.setX(input.nextDouble());
		circle1.setY(input.nextDouble());
		circle1.setRadius(input.nextDouble());
		
		System.out.println("Enter the coordinates x and y of the center of circle 2 and the radius");
		circle2.setX(input.nextDouble());
		circle2.setY(input.nextDouble());
		circle2.setRadius(input.nextDouble());
		
		distance = calculateDistance(circle1, circle2);
		
		if(areOverlapped(circle1, circle2))
			System.out.println("The two circles overlap each other");
		else if(areTouching(circle1, circle2))
			System.out.println("The two circles are touching each other");
		else if(areWithin(circle1, circle2))
			System.out.println("The two circles are within each other");
		else
			System.out.println("The two circles are separate from each other");
	}
	
	private double calculateDistance(Circle circle1, Circle circle2){
		return Math.sqrt(Math.pow(circle2.getX()-circle1.getX(), 2) + Math.pow(circle2.getY()-circle1.getY(), 2));
	}
	
	private boolean areOverlapped(Circle circle1, Circle circle2){
		return ((circle1.getRadius() + circle2.getRadius()) > distance) && (Math.abs(circle1.getRadius() - circle2.getRadius()) < distance);
	}
	
	private boolean areTouching(Circle circle1, Circle circle2){
		return ((circle1.getRadius() + circle2.getRadius()) == distance) || (Math.abs(circle1.getRadius() - circle2.getRadius()) == distance);
	}
	
	private boolean areWithin(Circle circle1, Circle circle2){
		return (circle1.getRadius() > (distance + circle2.getRadius())) || (circle2.getRadius() > (distance + circle1.getRadius()));
	}
}
	
	
	
	
		