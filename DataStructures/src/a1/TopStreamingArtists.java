package a1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Lubna Khalid
 * CISC 3130 - Professor Chuang
 * Data used - Global - Week ending Jan 23,2020 
 * 
 *
 */
public class TopStreamingArtists {


	// if u want to change the size the final variables will be easier to access here
	final static int COLS = 5;
	final static int ROWS = 200;
	public static void main(String[] args) {

		try {
			Scanner in = new Scanner(new File("global.csv"));
			PrintStream ps = new PrintStream("output.txt");
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			ps.println("Data processed at "+ timestamp);
			//use 2D array to read the CSV file as a table
			String[][] dataList = new String[ROWS][COLS];
			//use parallel arrays to read artist names in one and read how many times they appeared
			String[] artistNames = new String[ROWS];
			int[] parCount = new int[ROWS];
			readArr(dataList,in,artistNames);
			sortAlphabetically(dataList,artistNames);
			countReps(artistNames,parCount);
			int count = removeDuplicates(artistNames,parCount);
			ps.println("\nThe artists names alphabetically sorted using arrays: \n");
			for(int i =0;i<count;i++) {
				ps.println(artistNames[i]);
			}
			sortTopArtists(artistNames,parCount,count);
			ps.println("\nThe artists names sorted based on their streams(using parallel arrays): \n");
			for(int i =0;i<count;i++) {
				ps.println(artistNames[i]+" repeated "+parCount[i] + " times.");
			}

			ArtistList list = new ArtistList();
			for(int i = 0;i< count; i++) {
				list.insertLast(artistNames[i],parCount[i]);
			}
			ps.println("\nThe artists names using linked lists: \n");
			list.displayList(ps);
		} 

		// catches if the file called isn't found in the repository
		//i prefer try/catch over throwing exceptions.
		catch (FileNotFoundException e) {
			e.getMessage();
		}
	}


	/**
	 * by using bubble sort with the parallel array, I sort the artist array based on the times
	 * their name was repeated in the list
	 * @param artistNames
	 * @param parCount
	 * @param count
	 */
	private static void sortTopArtists(String[] artistNames, int[] parCount, int count) {

		int pass = 0;
		boolean swapped = false;
		do {
			pass++;
			swapped = false;
			for (int pos = 0; pos < count - pass; pos++)
				if (parCount[pos] < parCount[pos+1]) {
					//need to use temp as a placeholder to be able to swap later
					int tempInt = parCount[pos];
					String tempStr = artistNames[pos];
					parCount[pos] = parCount[pos+1];
					artistNames[pos] = artistNames[pos+1];
					parCount[pos+1] = tempInt;
					artistNames[pos+1] = tempStr;
					swapped = true;
				}
		} while(swapped == true);
	}



	// removes the duplicates of the artist names, also updates the parallel array with the size
	// uses sequential search to find duplicates, 
	// uses temporary parallel array to update size
	// returns int because populate the array, it's not 200 rows anymore
	private static int removeDuplicates(String[] artistNames, int[] parArr) {
		int[] countArr = new int[ROWS];
		String[] temp = new String[ROWS];
		int num = 0;

		for(int i = 0; i<ROWS-1;i++) {
			if(!artistNames[i].equals(artistNames[i+1])) {
				temp[num] = artistNames[i];
				countArr[num] = parArr[i];
				num++;
			}
		} 
		temp[num] = artistNames[ROWS-1];
		countArr[num]=parArr[ROWS-1];
		num++;

		for(int i = 0;i<num;i++) {
			artistNames[i] = temp[i];
			parArr[i] = countArr[i];
		}
		return num;
	}



	//counts the amount of repeats of an artist's name in the array
	private static void countReps(String[] artistNames, int[] countReps) {
		for(int i =0;i<ROWS;i++) {
			int count = 0;
			String target = artistNames[i];
			for(String s:artistNames) {
				if(s.equals(target))
					count++;
			}
			countReps[i] = count;
		}
	}

	// alphabetically sorts list using bubble sort
	private static void sortAlphabetically(String[][] dataList, String[] artistNames) {

		//this is bubble sorting, when you take the pairs and compare
		// use comparetoignorecase so you compare letters without worrying about the case
		// since the artist names are the same amount as the rows then use that as the count

		int pass = 0;
		boolean swapped = false;
		do {
			pass++;
			swapped = false;
			for (int pos = 0; pos < ROWS - pass; pos++)
				if (artistNames[pos].compareToIgnoreCase(artistNames[pos+1]) > 0) {
					//need to use temp as a placeholder to be able to swap later
					String temp = artistNames[pos];
					artistNames[pos] = artistNames[pos+1];
					artistNames[pos+1] = temp;
					swapped = true;
				}
		} while(swapped == true);
	}


	/**
	 * 
	 * @param dataList - send in the 2d array
	 * @param in - the scanner that reads the file
	 * the 2d array acts like a matrix/table, all data has a value on the table
	 * this way i can access the artists name in the third column 
	 * i can simply take one part of the table without worrying about losing data
	 * @param artistNames the 1D array with only the artist names
	 */
	private static void readArr(String[][] dataList, Scanner in, String[] artistNames) {

		int rows = 0;
		while(in.hasNext()&& rows <ROWS) {
			int cols = 0;
			int count = 0;
			String line = in.nextLine();
			while(cols< COLS) {
				String[] arr = line.split(",",5);
				dataList[rows][cols] = arr[count];

				count++;
				cols++;
			}
			rows++;
		}

		int count = 0;
		for(int i = 0;i<ROWS;i++) {
			//by using the structure of the table i put all the artist in one array so i can sort them
			artistNames[count] = dataList[i][2];
			if(artistNames[count].startsWith("\"") && artistNames[count].endsWith("\""))
			{
				artistNames[count] = artistNames[count].substring(1, artistNames[count].lastIndexOf("\""));
			}
			count++;
		}

	}

}
