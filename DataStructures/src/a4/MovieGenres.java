package a4;

import java.io.*;
import java.util.*;

public class MovieGenres {

	/* Plan: 
	 * 1)Take the data and put the movie genre with it's year on the hashmap
	 * 2)The key would be the genre and the value the name of the movie/year
	 */
	public static void main(String[] args) throws FileNotFoundException {

		Scanner in = new Scanner(new File("movies.csv"));
		HashMap<String,String> map = new HashMap<>();
		PrintStream ps = new PrintStream("outputA4.txt");
		while(in.hasNextLine()) {
			String input = in.nextLine();
			String title = input.substring(input.indexOf(',')+1, input.lastIndexOf(')')+1 );
			String genre;
			if(input.indexOf("|") == -1) {
				genre = input.substring(input.lastIndexOf(",")+1);
			}
			else {
			genre = input.substring(input.lastIndexOf(",")+1, input.indexOf("|"));
			}
			map.put(genre, title);
			
			ps.println("The title:  " +title + "and genre " + genre);
		}
	
		
	}

}
