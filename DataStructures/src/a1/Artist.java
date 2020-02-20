package a1;

public class Artist {

	String name;
	int count;
	Artist next;
	
	public Artist(String name,int count) {
		this.name = name;
		this.count = count;
	}
	
	public void displayArtist() {
		System.out.println(name + " was streamed " + count + " times.");
	}
}
