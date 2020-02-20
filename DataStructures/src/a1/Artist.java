package a1;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Artist {

	String name;
	int count;
	Artist next;
	public Artist(String name,int count) {
		this.name = name;
		this.count = count;
	}
	
	public void displayArtist(PrintStream ps) {
		ps.println(name + " was streamed " + count + " times.");
	}

}
