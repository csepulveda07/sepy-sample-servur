import javax.xml.soap.Node;

/*
Author: Clarissa Sepulveda with help from Professor Scarbnick
Sources: http://www.cs.princeton.edu/courses/archive/spr11/cos233/www/lib/exe/fetch.php?media=precept_4.pdf
http://code2care.org/2015/how-to-save-eclipse-console-logs-in-external-log-file/
Date: 5/13/2019
Purpose: This class creates and determines the optimal route for a traveling salesman based on the nearest locations and shortest increase in distance
in order to provide the shortest route
*/

public class MinimizeDistance {
	private Node head = null;
	private int size = 0;
	
	private class Node{
		private Location location;
		private Node next;
		
		/*
		 Purpose: This constructor initializes the location in each node and the next node
		 Parameters: The location being inserted into the node
		 Return: N/A
		*/
		public Node(Location location) {
			this.location = location;
			this.next = null;
		}
	}
	
	/*
	 Purpose: This method draws the route of the salesman using the drawTo method
	 Parameters: N/A
	 Return: N/A
	*/
	public void draw() {
		Node ptr = head;
		for(int index=0 ; index<size ; index++) {
			ptr.location.drawTo(ptr.next.location);
			ptr = ptr.next;
			
		}
		ptr.location.drawTo(head.location);
	}
	
	/*
	 Purpose: This method returns the total trip traveled by the salesman
	 Parameters: N/A
	 Return: A double representing the distance of the trip 
	*/
	public double distance() {
		double totalDistance = 0.0;
		Node ptr = head;
		for(int index=0 ; index<size ; index++) {
			totalDistance += ptr.location.distanceTo(ptr.next.location);
			ptr = ptr.next;
		}
		return totalDistance;
	}
	
	/*
	 Purpose: This method inserts a location into the linked-list based on the nearest location on the route
	 Parameters: The location being added to the route/linked-list
	 Return: N/A
	*/
	public void insertNearest(Location location) {
		Node inserted = new Node(location);
		if(size==0) {
			head = inserted;
			head.next = head;
		}
		else if(size == 1) {
			head.next = inserted;
			inserted.next = head;
		}
		else {
			Node ptr = head;
			double distance = ptr.location.distanceTo(location);
			Node nearest = ptr;
			for(int index=0 ; index<size ; index++) {
				if(distance>ptr.location.distanceTo(location)) {
					distance = ptr.location.distanceTo(location);
					nearest = ptr;
				}
				ptr = ptr.next;
			}
			inserted.next = nearest.next;
			nearest.next = inserted;
		}
		size++;
	}
	
	/*
	 Purpose: This method inserts a location into the linked-list that adds the least increase in the total distance of the route
	 Parameters: The location being added to the route/linked-list
	 Return: N/A
	*/
	public void insertSmallest(Location location) {
		Node inserted = new Node(location);
		if(size==0) {
			head = inserted;
			head.next = head;
		}
		else if(size == 1) {
			head.next = inserted;
			inserted.next = head;
		}
		else {
			Node ptr = head;
			double distance = (ptr.location.distanceTo(location) + location.distanceTo(ptr.next.location)) - ptr.location.distanceTo(ptr.next.location);
			Node smallest = ptr;
			for(int index=0 ; index<size ; index++) {
				if(distance>(ptr.location.distanceTo(location) + location.distanceTo(ptr.next.location)) - ptr.location.distanceTo(ptr.next.location)) {
					distance = (ptr.location.distanceTo(location) + location.distanceTo(ptr.next.location)) - ptr.location.distanceTo(ptr.next.location);
					smallest = ptr;
				}
				ptr = ptr.next;
			}
			inserted.next = smallest.next;
			smallest.next = inserted;
		}
		size++;
	}
	
	/*
	 Purpose: This method returns the size of the linked-list
	 Parameters: N/A
	 Return: An int value representing the number of nodes in the linked list
	*/
	public int size() {
		return size;
	}

	/*
	 Purpose: This method gathers all the coordinates of the locations in the linked-list/route
	 Parameters: N/A
	 Return: A String value representing all the coordinates in the linked-list/route
	*/	
	public String toString() {
		String locations = "";
		Node ptr = head;
		for(int index = 0; index<size ; index++) {
			locations += ptr.location.toString() + "\n";
			ptr = ptr.next;
		}
		return locations;
	}
}
	
