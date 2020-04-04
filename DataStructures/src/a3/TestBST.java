package a3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * 
 * @author Lubna
 * Plan of action;
 * 1) Use movies.csv and extract movie titles (they have their years in the title)
 * 2) Add these titles to a binary tree, so when you’re doing this you can also sort them alphabetically?
 * 3) Now that you have the movie title, get the year from the title [maybe go at it from the back of the name and look for the parentheses using substring?]
 * 4) Store the year as a separate value in each node
 * 5) Code a subset method that gives you all the movie titles between the start and end movies you wrote. Probably in alphabetical order. 
 */
public class TestBST {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("movies.csv"));
		PrintStream ps = new PrintStream("outputA3");
		MovieBST tree = new MovieBST();
		
		while(in.hasNextLine()) {
			String input = in.nextLine();
			int year = Integer.parseInt(input.substring(input.lastIndexOf('(')+1, input.lastIndexOf(')')));
			String title = input.substring(input.indexOf(',')+1, input.lastIndexOf('('));
			ps.println(title + " " + year);
			tree.addNode(title, year);
		
		
		}
		
		
	}

}
