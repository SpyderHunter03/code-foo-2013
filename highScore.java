import java.io.*;
import java.util.*;

// The sorting algorithm is simply the one that Comparable.sort() implements,
// which is Merge Sort.  The complexity of the algorithm is O(n log n) time.
// One way to reduce the complexity is to search for the insertion index in
// the container and insert the new score there and shift all the other scores
// down and delete the lowest one if there are greater than 'n' scores in the
// list.

public class highScore {
	static class Score implements Comparable<Score>{
		float score;
		String name;
		Score(String n, float s) {
			setScore(s);
			setName(n);
		}
		private void setName(String n) { name = n; }
		private void setScore(float s) { score = s;}
		public float getScore() { return score; }
		public String getName() { return name; }
		public int compareTo(Score sc) {
			if (score == sc.score)
				return 0;
			else if (score < sc.score)
				return 1;
			else
				return -1;
		}
		public String toString() {
			String r = new String(new StringBuffer(name).append(" ").append(score));
			return r;
		}
	}
	
	public static ArrayList<Score> highScores;
	public static int capacity;
	
	highScore(int n) throws FileNotFoundException {
		highScores = new ArrayList<Score> (n);
		capacity = n;
		Scanner in;
		File f = new File("highScores.hs");
		try {
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		in = new Scanner(f);
		
		while (in.hasNext()) {
			String name = "";
			float score = 0.0f;
			name = in.next();
			score = in.nextFloat();
			highScores.add(new Score(name,score));
		}	
	}

	public static void saveHighScores() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("highScores.hs"));
		for (int i = 0; i < 10; i++) {
			String w = new String(new StringBuffer(highScores.get(i).getName()).append(" ").append(highScores.get(i).getScore()));
			bw.write(w);
		}
		bw.close();
	}
	
	public static void addScore(String n, float s) {
		Score score = new Score(n,s);
		if (highScores.size() < capacity) {
			highScores.add(highScores.size(), score);
			Collections.sort(highScores);
		} else if (highScores.size() == capacity) {
			if (score.getScore() >= highScores.get(capacity-1).getScore()) {
				highScores.remove(highScores.size()-1);
				highScores.add(highScores.size()-1, score);
				Collections.sort(highScores);
			}
		}
	}
	
	public static void printScores() {
		for (int i = 0; i < highScores.size(); i++) {
			System.out.println(highScores.get(i));
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		try {
			new highScore(10);
			addScore("TRG1", 20);
			printScores();
			addScore("TRG2", 200);
			printScores();
			addScore("TRG3", 20);
			printScores();
			addScore("TRG4", 10);
			printScores();
			addScore("TRG5", 2000);
			printScores();
			addScore("TRG6", 20);
			printScores();
			addScore("TRG7", 10);
			printScores();
			addScore("TRG8", 5);
			printScores();
			addScore("TRG9", 20);
			printScores();
			addScore("TRG10", 20);
			printScores();
			addScore("TRG11", 20);
			printScores();
			addScore("TRG12", 50);
			printScores();
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found!");
		}
	}
}
