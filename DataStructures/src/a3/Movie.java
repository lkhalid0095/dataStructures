package a3;

public class Movie {

	//node for the movie binary tree
	//the title is the key
	String title;
	int releaseYear;

	Movie left;
	Movie right;

	Movie(String key, int year){
		title = key;
		releaseYear = year;


	}
	
	//overriding toString method

	public String toString() {
		return title + "was released in " + releaseYear;
	}
}
