public class TestBST {

	public static void main(String[] args) {

		// Example 1: a BST of Strings
		
		// Create a BST
		BST<String> tree = new BST<>();
		tree.insert("George");
		tree.insert("Michael");
		tree.insert("Tom");
		tree.insert("Adam");
		tree.insert("Jones");
		tree.insert("Peter");
		tree.insert("Daniel");

		// Traverse tree
		System.out.print("Inorder (sorted): ");
		tree.inorder();
		System.out.print("\nPostorder: ");
		tree.postorder();
		System.out.print("\nPreorder: ");
		tree.preorder();
		System.out.print("\nThe number of nodes is " + tree.getSize());

		// Search for an element
		System.out.print("\nIs Peter in the tree? " + 
				tree.search("Peter"));

		// Get a path from the root to Peter
		System.out.print("\nA path from the root to Peter is: ");
		java.util.ArrayList<BST.TreeNode<String>> path 
		= tree.path("Peter");

		for (int i = 0; path != null && i < path.size(); i++)
			System.out.print(path.get(i).element + " ");

		
		// Example 2: a BST of Integers	
		Integer[] numbers = {2, 4, 3, 1, 8, 5, 6, 7};
		BST<Integer> intTree = new BST<>(numbers); 
		System.out.print("\nInorder (sorted): ");
		intTree.inorder();



		// Example 3: a BST of StudentRecords
		
		    BST<StudentRecord> studentRecords = new BST<>();
		    studentRecords.insert(new StudentRecord("Kevin", "Egan"));
      	    studentRecords.insert(new StudentRecord("Puja", "Verma"));
		    studentRecords.insert(new StudentRecord("Etienne", "Vouga"));
		    studentRecords.insert(new StudentRecord("Brittney", "Kuhn"));
		    studentRecords.insert(new StudentRecord("Miklos", "Bergou"));
		    studentRecords.insert(new StudentRecord("Hila", "Becker"));
		    studentRecords.insert(new StudentRecord("Arjun", "Verma"));
		    studentRecords.preorder();
		    studentRecords.inorder();
	}
}