/*
	Question 6: Prompts the user to enter the coordinates of the center of two circles and their radius.
				It will determine if the two circles are within, separate, overlap, or touch each other.
	Resources for math formulas: 
	http://www.ambrsoft.com/TrigoCalc/Circles2/circle2intersection/CircleCircleIntersection.htm
	https://stackoverflow.com/questions/33490334/check-if-a-circle-is-contained-in-another-circle
	Command to run on the command line: java TwoCircles.TwoCirclesApp
*/
package TwoCircles;

import TwoCircles.TwoCircles;

public class TwoCirclesApp{
	public static void main(String[] args){
		TwoCircles twoCircles = new TwoCircles();
		
		twoCircles.run();
	}
}