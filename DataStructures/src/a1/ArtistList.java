package a1;

import java.io.PrintStream;

public class ArtistList {

	/**
	 *  each artist represent a node. 
	 */

	Artist first;
	//Artist last;
	int size;
	public ArtistList() {
		first = null;
		size = 0;
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
		while(current.next != null) {
			current.displayArtist(ps);
			current = current.next;
		}
		//since it's checking the address of the next node, the last element wouldn't print 
		//unless i print the last element here
		current.displayArtist(ps);
		

	}


}//end of class
