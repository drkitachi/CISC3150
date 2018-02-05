package RealTriangle;

import java.util.Scanner;
import RealTriangle.TwoDPoint;

public class RealTriangle{
	private TwoDPoint a;
	private TwoDPoint b;
	private TwoDPoint c;
	private double sideAB;
	private double sideBC;
	private double sideCA;
	
	public RealTriangle(){
		a = new TwoDPoint();
		b = new TwoDPoint();
		c = new TwoDPoint();
	}
	
	public void run(){
		readPoints();
		
		sideAB = calculateSide(a,b);
		sideBC = calculateSide(b,c);
		sideCA = calculateSide(c,a);
		
		if(checkTriangle())
			System.out.println("This is a real triangle");
		else
			System.out.println("This is a fake triangle");
		
	}
	
	private double calculateSide(TwoDPoint p1, TwoDPoint p2){
		double x1 = p1.getX(), y1 = p1.getY();
		double x2 = p2.getX(), y2 = p2.getY();
		return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
	}
	
	private void readPoints(){
		Scanner input = new Scanner(System.in);
		double x, y;
		
		System.out.println("Enter the x and y coordinates of point A");
		x = input.nextDouble();
		y = input.nextDouble();
		a.setX(x);
		a.setY(y);
		
		System.out.println("Enter the x and y coordinates of point B");
		x = input.nextDouble();
		y = input.nextDouble();
		b.setX(x);
		b.setY(y);
		
		System.out.println("Enter the x and y coordinates of point C");
		x = input.nextDouble();
		y = input.nextDouble();
		c.setX(x);
		c.setY(y);
	}
	
	private boolean checkTriangle(){
		if((sideAB + sideBC) <= sideCA) return false;
		if((sideBC + sideCA) <= sideAB) return false;
		if((sideAB + sideCA) <= sideBC) return false;
		
		return true;
	}
}