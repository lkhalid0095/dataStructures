package a2;

import java.io.*;
import java.util.*;

import a1.*;

public class TestApp {

	public static void main(String[] args) throws FileNotFoundException {
		PrintStream ps = new PrintStream(new File("outputA2.txt"));
		//create an array with my file names to iterate through
		//even though you have to edit the file names and the number
		//of files, I'm comfortable with arrays.
		String[] myFiles = {"week1.txt","week2.txt"};
		//a list of queues
		ArrayList<MyQueue> weekList = new ArrayList<>();
		MyQueue data = new MyQueue();
		//iterates through file names and makes a queue
		//adds the queue to the array list.
		for(int i = 0;i<myFiles.length;i++) {
			data = new MyQueue(myFiles[i]);
			data = data.convertQ();
			weekList.add(data);

		}// end of for loop
		ps.println("The queue's sorted individually without merging, in the Array List");
		ps.println("\nQUEUE #1\n");
		for(int i =0;i<weekList.size();i++) {
			weekList.get(i).displayList(ps);
			if(i ==0)
				ps.println("\nQUEUE #2\n");
		}

		ps.println("\nMY SORTED PLAYLIST\n");
		Playlist playlist = Playlist.read(myFiles[1]);
		SongHistoryList list = new SongHistoryList();
		//randomly listening to songs to create a history list
		for(int i =0;i<23;i++)
			playlist.listenToSong(list);

		//displays the playlist without the songs I've already listened to
		playlist.displayList(ps);

		//displays the songs I've listened to from the week 2
		ps.println("\nMY PLAYLIST HISTORY\n");
		list.displayList(ps);
		Song s = list.lastListened();
		ps.println("\nThe last song you listened to was: "); 
		s.displaySong(ps);

	}//end of main

}//end of class
