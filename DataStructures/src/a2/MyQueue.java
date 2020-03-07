package a2;

import java.io.*;
import java.util.*;

import a1.ArtistList;


public class MyQueue extends ArtistList{
	
	String filename;

	
	//needed a non-args constructor for the convertQ method
	public MyQueue() {
	}
	//taking the filename, and converting in to a queue.
	public MyQueue(String filename) throws FileNotFoundException {
		this.filename = filename;
	}
	
	/*I couldn't understand why the Queue wasn't updating when I wrote 
	 * this in the main method and it took me a while and I realized that
	 * since the changes made weren't saved to the queue that was being returned
	 * I couldn't store it in the testApp. So i wrote this method. 
	 */
	public MyQueue convertQ() throws FileNotFoundException  {
		Scanner in = new Scanner(new File(filename));
		MyQueue list = new MyQueue();
		while(in.hasNextLine()) {
			String songName = in.nextLine();
			list.insertFirst(songName);
			list.sortAlphabetically();
		}
		return list;
	}


}//end of  queue

