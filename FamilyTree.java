import java.util.*;

// This algorithm is O(n) where n is the number of people in the family tree.
//
// This family tree only takes a persons name and the generation that they are in
// as considered variables because that is the bare essentials of what any family
// tree must have.


public class FamilyTree {
	static class Person {
		private String name;
		private int generation;
		Person(String n, int g) {
			setName(n);
			setGen(g);
		}
		private void setName(String n) { name = n; }
		private void setGen (int g) { generation = g; }
		public String getName() { return name; }
		public int getGen() { return generation; }
		public String toString() { return name + " Generation:" + generation; }
	}
	public static Vector<Person> tree = new Vector<Person> ();
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = "";
		
		// Populate family tree
		A: do {
			System.out.println("[Populate Tree] Enter name (Enter if done):");
			input = in.nextLine();
			if (input.isEmpty())
				break A;
			System.out.println("[Populate Tree] Enter generation:");
			tree.add(new Person(input,Integer.parseInt(in.nextLine())));
		} while (true);
		
		// Search family tree
		B: do {
			System.out.println("[Search Tree] Enter name or generation(Enter if done):");
			input = in.nextLine();
			if (input.isEmpty())
				break B;
			try {
				int gen = Integer.parseInt(input);
				for (int i = 0; i < tree.size(); i++) {
					if (tree.get(i).getGen() == gen) {
						System.out.println(tree.get(i));
					}
				}
			} catch (NumberFormatException e) {
				for (int i = 0; i < tree.size(); i++) {
					if (tree.get(i).getName().toLowerCase().contains(input.toLowerCase())) {
						System.out.println(tree.get(i));
					}
				}
			}
			System.out.println();
		} while (true);
		
		System.out.println("Good bye!");
	}

}
