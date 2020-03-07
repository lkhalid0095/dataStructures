package a2;
//to find which song was last listened to
//we use the data structure of a stack
//since we want the data to be last in first out

import java.io.PrintStream;

public class SongHistoryList {
	Song first;
	Song last;

	public SongHistoryList() {
		first = null;
		last = null;
	}

	public void addSong(String data) {


		Song newNode = new Song(data);
		// if the list is empty then the first node would be assigned the new node
		newNode.next = null;

		if(first == null) {
			last = newNode;
	
		}
		//but if the list isn't empty, you iterate through the list
		//until you find a node that points to an empty node and make that equal to the new node.
		newNode.next = first;
		first = newNode;


	}
	//returns the last listened song on from the playlist, which is the first song
	public Song lastListened() {
		return first;
	}

	//displays the list by iterating through out the list
	public void displayList(PrintStream ps) {
		Song current = first;
		while(current!= null) {
			current.displaySong(ps);
			current = current.next;
		}


	}
}

