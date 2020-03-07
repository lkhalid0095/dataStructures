package a1;

import java.io.PrintStream;

public class ArtistList {

	/**
	 *  each artist represent a node. 
	 */

	Artist first;
	Artist last;
	int size;
	public ArtistList() {
		first = null;
		last = null;
		size = 0;
	}

	// for the second assignment I added this method
	//inserts the arguments to the first node.

	public void insertFirst(String data) {

		Artist newNode = new Artist(data);
		// if the list is empty then the first node would be assigned the new node
		newNode.next = null;

		if(first == null) {
			last = newNode;
			size++;
		}
		//but if the list isn't empty, you iterate through the list
		//until you find a node that points to an empty node and make that equal to the new node.
		newNode.next = first;
		first = newNode;
		size++;

	}
	//1 arg constructors.
	public void insertLast(String data) {

		Artist newNode = new Artist(data);
		// if the list is empty then the last node would be assigned the new node
		newNode.next = null;

		if(first == null) {
			first = newNode;
			size++;
		}
		//but if the list isn't empty, you iterate through the list
		//until you find a node that points to an empty node and make that equal to the new node.
		else {
			Artist temp = first;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
			size++;
		}

	}
	//inserts the arguments to the last node. (Since my array was in an alphabetical order, adding to the last node made more sense
	public void insertLast(String data,int count) {

		Artist newNode = new Artist(data,count);
		// if the list is empty then the last node would be assigned the new node
		newNode.next = null;

		if(first == null) {
			first = newNode;
			size++;
		}
		//but if the list isn't empty, you iterate through the list
		//until you find a node that points to an empty node and make that equal to the new node.
		else {
			Artist temp = first;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
			size++;
		}

	}
	// i ended up not using the delete method, but it was still a valuable method, 
	// so i didn't delete it.
	public void delete(int idx) {
		//if you're deleting the first element then the next element will become first
		if(idx == 0) {
			first = first.next;
		}
		// you need a node with no value (null)
		//a node that points at head to iterate through loop starting from the first
		// can use a for loop like you do with arrays making idx the limit?
		else {
			Artist current = first;
			Artist temp = null;
			// travel to the location that needs to be deleted
			for(int i=0;i<idx-1;i++) {
				current = current.next;
			}
			//delete the element and now you're pointing to the element that the deleted element was pointing to. 
			temp = current.next;
			current.next = temp.next;

		}
	}
	//returns the size of the array
	public int size() {
		return size;
	}


	//prints the node of the list using the same iteration process like we did earlier in insert
	public void displayList(PrintStream ps) {
		Artist current = first;
		while(current!= null) {
			current.displayArtist(ps);
			current = current.next;
		}



	}

	// alphabetically sorts list using bubble sort
	//i added this for the second assigment, used the same process like an array
	// but instead of comparing strings i compared nodes
	public Artist sortAlphabetically() {

		//this is bubble sorting, when you take the pairs and compare
		// use comparetoignorecase so you compare letters without worrying about the case
		// since the artist names are the same amount as the rows then use that as the count
		Artist start = first;
		boolean swapped = false;
		Artist temp;
		Artist current = null;
		if(start == null)
			return null;
		do {
			swapped = false;
			temp = start;
			while(temp.next != current) {
				if (temp.name.compareToIgnoreCase(temp.next.name) > 0) {
					//need to use temp as a placeholder to be able to swap later
					String str = temp.name;
					temp.name = temp.next.name;
					temp.next.name = str;
					swapped = true;
				}
				temp = temp.next;
			}
			current = temp.next;

		} while(swapped == true);
		
		 	return start;
	}


}//end of class
