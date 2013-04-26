import java.util.Scanner;


public class wordSearch {
	public static char[][] wordGrid = 
		{{'x','n','t','g','j','h','e','a','l','t','h','u','s','k','b','w','a','s','t','a'},//0
		 {'s','o','u','j','y','n','z','w','x','b','t','g','m','v','y','b','o','l','a','h'},//1
		 {'h','t','i','l','t','s','l','e','q','d','c','r','a','n','d','r','p','x','z','b'},//2
		 {'p','s','h','e','p','b','n','o','r','e','b','a','z','o','o','k','a','s','b','u'},//3
		 {'l','i','d','n','o','l','y','p','r','v','a','s','j','p','p','j','o','s','r','d'},//4
		 {'i','e','v','y','r','u','m','g','b','e','l','s','g','r','y','l','h','c','x','z'},//5
		 {'a','h','m','h','o','n','k','i','l','l','t','a','c','u','l','a','r','o','b','y'},//6
		 {'b','o','i','e','q','d','o','n','s','y','b','s','o','t','x','o','g','r','a','p'},//7
		 {'h','o','w','i','t','e','u','z','a','t','y','s','e','d','o','b','f','e','v','s'},//8
		 {'a','i','s','c','a','r','k','a','e','i','d','i','s','i','c','h','i','o','p','t'},//9
		 {'o','d','b','a','d','b','o','h','d','r','y','n','y','l','e','v','e','l','a','e'},//10
		 {'l','d','k','u','i','u','j','i','r','e','g','s','d','a','s','q','a','b','g','v'},//11
		 {'d','i','u','c','b','s','t','a','d','l','k','l','h','y','a','s','p','i','l','e'},//12
		 {'v','o','j','c','i','s','h','j','g','o','d','y','o','o','m','g','o','l','d','s'},//13
		 {'w','r','i','l','k','d','b','g','l','a','y','i','r','i','s','t','g','x','g','m'},//14
		 {'l','t','s','c','r','a','g','a','h','d','e','s','d','q','b','a','h','w','d','o'},//15
		 {'h','e','a','l','t','i','r','n','o','f','u','y','e','a','l','w','y','e','h','m'},//16
		 {'f','m','u','s','h','r','o','o','m','e','h','a','p','p','i','n','d','r','t','o'},//17
		 {'l','h','f','h','p','y','o','n','u','k','a','c','o','l','a','o','r','e','b','v'},//18
		 {'p','a','r','e','l','z','d','d','k','a','p','r','o','t','o','m','a','n','p','l'},//19
		 {'m','j','o','p','o','u','y','o','m','l','q','u','a','l','i','n','l','d','w','y'},//20
		 {'w','a','p','a','n','y','r','r','r','j','y','o','a','h','z','n','i','x','e','m'},//21
		 {'m','l','s','r','i','w','h','f','t','i','n','o','g','r','o','l','s','e','y','s'},//22
		 {'l','y','l','d','n','i','k','u','o','y','d','l','u','o','w','u','k','d','e','o'},//23
		 {'o','y','o','q','y','a','k','d','j','e','b','l','u','n','d','e','r','s','c','u'}};//24
	
	public static enum Direction {
		NW, N, NE, W, E, SW, S, SE
	}
	
	// Prints the word grid
	public static void printGrid() {
		for(int row = 0; row < 25; row++){
			for(int column = 0; column < 20; column++) {
				System.out.print(wordGrid[row][column] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	// Prints the answer for the word if found in the word grid
	public static void printAnswer(int r, int c, String input, Direction dir) {
		System.out.println(input + " was found at Row:" + (r+1) + " and Column:" + 
						   (c+1) + " in the " + dir + " direction!");
	}
	
	// Searches the grid for input in the dir Direction starting at r and c
	public static boolean searchWord(int r, int c, String input, Direction dir) {
		int row = r;
		int column = c;
		try {
			switch (dir) {
				case NW:
					for(int i = 0; i < input.length(); i++, row--, column--) {
						if (wordGrid[row][column] != input.charAt(i)) {
							return false;
						}
					}
					return true;
				case N:
					for(int i = 0; i < input.length(); i++, row--) {
						if (wordGrid[row][column] != input.charAt(i)) {
							return false;
						}
					}
					return true;
				case NE:
					for(int i = 0; i < input.length(); i++, row--, column++) {
						if (wordGrid[row][column] != input.charAt(i)) {
							return false;
						}
					}
					return true;
				case W:
					for(int i = 0; i < input.length(); i++, column--) {
						if (wordGrid[row][column] != input.charAt(i)) {
							return false;
						}
					}
					return true;
				case E:
					for(int i = 0; i < input.length(); i++, column++) {
						if (wordGrid[row][column] != input.charAt(i)) {
							return false;
						}
					}
					return true;
				case SW:
					for(int i = 0; i < input.length(); i++, row++, column--) {
						if (wordGrid[row][column] != input.charAt(i)) {
							return false;
						}
					}
					return true;
				case S:
					for(int i = 0; i < input.length(); i++, row++) {
						if (wordGrid[row][column] != input.charAt(i)) {
							return false;
						}
					}
					return true;
				case SE:
					for(int i = 0; i < input.length(); i++, row++, column++) {
						if (wordGrid[row][column] != input.charAt(i)) {
							return false;
						}
					}
					return true;
			}
		} catch ( ArrayIndexOutOfBoundsException e ){
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Direction dir = Direction.N;
		Scanner s = new Scanner(System.in);
		printGrid();
		String input;
		String in;
		do {
			input = in = "";
			System.out.println("What word would would you like to find (Enter to exit):");
			in = s.nextLine();
			input = in.replaceAll(" ", "").toLowerCase();
			if (input.length() > 0) {
				//search grid for first letter
				//Use break A after word found
				A: for(int row = 0; row < 25; row++){
					for(int column = 0; column < 20; column++) {
						if (wordGrid[row][column] == input.charAt(0)){
							//Check box of letters around first letter
							if (input.length() > 1) {
								for(int i = -1; i <= 1; i++) {
									for(int j = -1; j <= 1; j++) {
										try {
											if ((wordGrid[row + i][column+j] == input.charAt(1)) && (i!=0 || j!=0)) {
												if (i < 0) {
													if (j < 0) {
														dir = Direction.NW;
													} else if (j == 0) {
														dir = Direction.N;
													} else {
														dir = Direction.NE;
													}
												} else if (i == 0) {
													if (j < 0) {
														dir = Direction.W;
													} else {
														dir = Direction.E;
													}
												} else {
													if (j < 0) {
														dir = Direction.SW;
													} else if (j == 0) {
														dir = Direction.S;
													} else {
														dir = Direction.SE;
													}
												}
												if(searchWord(row,column,input,dir)) {
													printAnswer(row,column,in,dir);
													break A;
												}
											}
										} catch ( ArrayIndexOutOfBoundsException e ){}
									}
								}
							//----------------------------------------	
							} else { // Input only one char
								System.out.println((row+1) + " " + (column+1));
							}
						}
					}
				}
			} else {
				System.out.println("Have a good day!");
				System.exit(0);
			}
		} while (input.length() != 0);
	}
}
