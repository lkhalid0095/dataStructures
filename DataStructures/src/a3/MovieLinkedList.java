package a3;

import a1.Artist;

public class MovieLinkedList {

	MovieA3 first;
	MovieA3 last;
	int size;
	public MovieLinkedList() {
		first = null;
		last = null;
		size = 0;
	}
	
	public void insertLast(String name, int year ) {

		MovieA3 newNode = new MovieA3(name, year);
		// if the list is empty then the last node would be assigned the new node
		newNode.next = null;

		if(first == null) {
			first = newNode;
			size++;
		}
		//but if the list isn't empty, you iterate through the list
		//until you find a node that points to an empty node and make that equal to the new node.
		else {
			MovieA3 temp = first;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
			size++;
		}

	}
	
	public MovieA3 sortAlphabetically() {

		
		
		
		//this is bubble sorting, when you take the pairs and compare
		// use comparetoignorecase so you compare letters without worrying about the case
		// since the artist names are the same amount as the rows then use that as the count
		MovieA3 start = first;
		boolean swapped = false;
		MovieA3 temp;
		MovieA3 current = null;
		if(start == null)
			return null;
		do {
			swapped = false;
			temp = start;
			while(temp.next != current) {
				if (temp.title.compareToIgnoreCase(temp.next.title) > 0) {
					//need to use temp as a placeholder to be able to swap later
					String str = temp.title;
					temp.title = temp.next.title;
					temp.next.title = str;
					swapped = true;
				}
				temp = temp.next;
			}
			current = temp.next;

		} while(swapped == true);
		
		 	return start;
	}
	
}
