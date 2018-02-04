/*	
	Question 5: Computes the sides of a triangle and check if real or not
	
*/

import java.util.Scanner;
import RealTriangle.TwoDPoint;

public class RealTriangle{
	private static TwoDPoint a;
	private static TwoDPoint b;
	private static TwoDPoint c;
	
	RealTriangle(){
		a = new TwoDPoint();
		b = new TwoDPoint();
		c = new TwoDPoint();
	}
	
	public static void main(String[] args){
		double sideAB, sideBC, sideCA;
		RealTriangle triangle = new RealTriangle();
		
		triangle.readPoints();
		
		sideAB = triangle.calculateSide(a,b);
		sideBC = triangle.calculateSide(b,c);
		sideCA = triangle.calculateSide(c,a);
		
		if(triangle.checkTriangle(sideAB,sideBC,sideCA))
			System.out.println("This is a real triangle");
		else
			System.out.println("This is a fake triangle");
		
	}
	
	double calculateSide(TwoDPoint p1, TwoDPoint p2){
		double x1 = p1.getX(), y1 = p1.getY();
		double x2 = p2.getX(), y2 = p2.getY();
		return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
	}
	
	void readPoints(){
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
	
	boolean checkTriangle(double sideAB, double sideBC, double sideCA){
		if((sideAB + sideBC) <= sideCA) return false;
		if((sideBC + sideCA) <= sideAB) return false;
		if((sideAB + sideCA) <= sideBC) return false;
		
		return true;
	}
}