package a2;

import java.io.PrintStream;

public class Song {
	//song is the node of the playlist (stack)
	 String track;
	 Song next;
	
	//no-args constructor
	public Song() {
		track = "";
	}
	
	//args constructor
	public Song(String track) {
		this.track = track;
	}
	
	//displays the name of the song 
	public void displaySong(PrintStream ps) {
		ps.println(track);
	}
}
