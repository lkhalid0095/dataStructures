package a2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import a1.Artist;

public class Playlist{
	private Song first;
	private Song last;
	// a list of all the songs you've listened to
	/**
	 * this is a linked list which is implemented as a queue
	 * we add a song to the end of the list, and we listen to
	 * it in the order we add it. So it's a logical structure of a queue 
	 */
	public  Playlist()  {
		first  = null;
		last = null;
	}

	//adds a song to the end of the list
	public void addSong(String name) {

		Song newNode = new Song(name);

		// if the list is empty then the last node would be assigned the new node
		newNode.next = null;

		if(first == null) {
			first = newNode;
		}
		//but if the list isn't empty, you iterate through the list
		//until you find a node that points to an empty node and make that equal to the new node.
		else {
			Song temp = first;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}
	
	//it returns the song that you're going listening to next,
	// after the song you're currently listening to
	//if there is only one song then the next would be null, so you'd return first
	//if the song isn't the only one, it'll return the song after
	//something i might do later is remove a song as you've listened to it
	public Song listenToSong(SongHistoryList list) {
		if(first.next != null) {
			//you make a 
			list.addSong(first.track);
			//if the first song isn't the only song then you remove it and return the next
			//song on the list.
			first = first.next;
		}
		
		return first;
	}

	//prints the node of the list using the same iteration process like we did earlier in insert
	public void displayList(PrintStream ps) {
		Song current = first;
		while(current!= null) {
			current.displaySong(ps);
			current = current.next;
		}



	}
	public Song sortList() {

		//this is bubble sorting, when you take the pairs and compare
		// use comparetoignorecase so you compare letters without worrying about the case
		// since the artist names are the same amount as the rows then use that as the count
		Song start = first;
		boolean swapped = false;
		Song temp;
		Song current = null;
		if(start == null)
			return null;
		do {
			swapped = false;
			temp = start;
			while(temp.next != current) {
				if (temp.track.compareToIgnoreCase(temp.next.track) > 0) {
					//need to use temp as a placeholder to be able to swap later
					String str = temp.track;
					temp.track = temp.next.track;
					temp.next.track = str;
					swapped = true;
				}
				temp = temp.next;
			}
			current = temp.next;

		} while(swapped == true);
		
		 	return start;
	}
	// reads a file in to a playlist, in this case I only read one, but you can read multiple
	public static Playlist read(String filename) throws FileNotFoundException {
		Scanner in = new Scanner(new File(filename));
		Playlist list = new Playlist();
		while(in.hasNextLine()) {
			String songName = in.nextLine();
			list.addSong(songName);
			list.sortList();
		}
		return list;
	}

}
