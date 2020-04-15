package a3;

public class MovieA3 {

	//node for the movie binary tree
	//the title is the key
	public String title;
	int releaseYear;

	public MovieA3 left;
	public MovieA3 right;
	public MovieA3 next; //linked list

	public MovieA3(String key, int year){
		title = key;
		releaseYear = year;


	}
	
	//overriding toString method

	public String toString() {
		return title + "was released in " + releaseYear;
	}
}
