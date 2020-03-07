package a1;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Artist {

	String name;
	int count;
	Artist next;
	//1 arg constructor for the second assignment
	public Artist(String name) {
		this.name = name;
	}
	//two-args constructor for the first assignment
	public Artist(String name,int count) {
		this.name = name;
		this.count = count;
	}
	
	public void displayArtist(PrintStream ps) {
		ps.println(name);
	}

}
