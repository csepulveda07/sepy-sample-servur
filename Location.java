/*
Author: Clarissa Sepulveda with help from Professor Scarbnick
Sources: N/A
Date: 11/13/15
Purpose: This class allocates memory of x & y coordinates for locations in a linked-list
*/

public class Location{
	private double x;
	private double y;
	
	/*
	 Purpose: This constructor initializes the coordinates for a location
	 Parameters: The x and y coordinates of the location
	 Return: N/A
	*/
	public Location(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/*
	 Purpose: This method provides a String value of the coordinates of the location 
	 Parameters: N/A
	 Return: A String value of the coordinates
	*/
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
	/*
	 Purpose: This method draws a line between two locations using their x & y coordinates
	 Parameters: the location being drawn to
	 Return: N/A
	*/
	public void drawTo(Location b) {
		StdDraw.line(b.x, b.y, this.x, this.y);
	}
	
	/*
	 Purpose: This method determines the distance between two locations using their x & y coordinates
	 Parameters: The location whose distance is being determined
	 Return: A double representing the distance of the two locations
	*/
	public double distanceTo(Location b) {
		return Math.sqrt(Math.pow(b.x-this.x, 2) + Math.pow(b.y-this.y, 2));
	}
}
