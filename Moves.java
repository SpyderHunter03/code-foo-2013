import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


public class Moves {
	public static ArrayList<char[]> wordList = new ArrayList<char[]>();
	public static ArrayList<String> moveList = new ArrayList<String>();
	public static int moves = 0;
	public static String first = "";
	public static String second = "";
	
	// Searches the word list to make sure that the word is a legal word
	public static boolean wordFind(char[] word) {
		for(int i = 0; i < wordList.size(); i++) {
			if (wordList.get(i)[0] == word[0] && wordList.get(i)[1] == word[1] && wordList.get(i)[2] == word[2]) {
				return true;
			}
		}
		return false;
	}
	
	// Runs through loop checking each letter position in f to letter position in s
	// and if it doesn't match then we change the letter in t to letter in s and
	// check if t is a legal word.  If yes then make f = t, if not then change back
	// to f and check next letter.
	public static boolean directMove(char[] f, char[] s) {
		char[] t = f.clone();
		moveList.add(new String(f));
		do {
			for(int i = 0; i < 3; i++) {
				if(f[i] != s[i]) {
					t[i] = s[i];
					if(wordFind(t)) {
						f[i] = t[i];
						moveList.add(new String(f));
					} else {
						t[i] = f[i];
					}
				}
			}
		} while (!(f[0] == s[0] && f[1] == s[1] && f[2] == s[2]) && moveList.size() > 2);
				// if something changed and f still != s
		if (f[0] == s[0] && f[1] == s[1] && f[2] == s[2]) {
			return true;
		} else {
			return false;
		}
	}
	
	// Called when no direct moves can be made and a search of the alphabet needs
	// to be done to try an indirect approach of changing the letters
	public static boolean indirectMove(char[] f, char[] s) {
		char[] t = f.clone();
		for(int i = 0; i < 3; i++) {
			for(int j = 65; j < 91; j++) {
				t[i] = (char)j;
				if(wordFind(t)) {
					if (!directMove(t,s)) {
						moveList.clear();
						moveList.add(new String(f));
					} else {
						return true;
					}
				}
			}
			t = f.clone();
		}
		return false;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		char[] f = null;
		char[] s = null;
		boolean found = false;
		
		// Import words from file to wordList
		try {
			Scanner fileIn = new Scanner(new BufferedReader(new FileReader("three-letter-words.txt")));
			while(fileIn.hasNext()) {
				wordList.add(fileIn.next().toUpperCase().toCharArray());
			}
		} catch ( FileNotFoundException e ){
			System.out.println("File Not Found.  Looking for three-letter-words.txt");
		}
		
		// Read in words from user
		Scanner in = new Scanner(System.in);
		while (first.length() != 3) {
			System.out.println("First three letter word:");
			first = in.next().toUpperCase();
			f = first.toCharArray();
			if(!wordFind(f)) {
				first = "";
				System.out.println("Not a valid word");
			}
		}
		while (second.length() != 3) {
			System.out.println("Second three letter word:");
			second = in.next().toUpperCase();
			s = second.toCharArray();
			if(!wordFind(s)) {
				second = "";
				System.out.println("Not a valid word");
			}
		}
		
		// Change first into second
		System.out.println("----------------------------");
		found = directMove(f,s);
		if (found) {
			System.out.print(moveList);
			System.out.println(" " + (moveList.size()-1) + " moves");
		} else {
			found = indirectMove(f,s);
			if (found) {
				System.out.print(moveList);
				System.out.println(" " + (moveList.size()-1) + " moves");
			} else {
				System.out.println("Can't happen");
			}
		}
	}
}
