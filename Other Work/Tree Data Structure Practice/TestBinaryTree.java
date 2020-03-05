public class TestBinaryTree {

     public static void main(String[] args) {
         
		BinaryTree bTree = new BinaryTree();
		bTree.insert(5);
		bTree.insert(3);
		bTree.insert(9);
		bTree.insert(1);
		bTree.insert(4);
		bTree.insert(6);

		System.out.println("In-order traversal sequence :");
		bTree.inOrder();

		System.out.println("Pre-order traversal sequence :");
		bTree.preOrder();

		System.out.println("Post-order traversal sequence :");
		bTree.postOrder();

		System.out.println("Level-order traversal sequence :");
		bTree.levelOrder();

		// bTree.mirror();        
		// System.out.println("In-order traversal sequence (after mirroring) :");
		// bTree.inOrder();

		System.out.println("Delete a leaf node");
		bTree.delete(6);
		bTree.preOrder();
		bTree.insert(6);
		
		System.out.println("Delete the root");
		bTree.delete(5);
		bTree.preOrder();
		
		bTree.clear();
		
		bTree.insert(30);
		bTree.insert(20);
		bTree.insert(50);
		bTree.insert(10);
		bTree.insert(25);
		bTree.insert(40);
		bTree.insert(60);
		bTree.insert(22);
		bTree.insert(28);
		bTree.insert(27);
		bTree.insert(29);
		bTree.insert(51);
		bTree.insert(59);
		bTree.insert(57);
		bTree.preOrder();
		
		System.out.println("Delete 30 (the root)");
		bTree.delete(30);
		bTree.preOrder();
		
		bTree.clear();
		
		// Case where the rightmost node has a left subtree
		// that needs to be linked to after the rightmost node
		// is deleted
		bTree.insert(30);
		bTree.insert(5);
		bTree.insert(1);
		bTree.insert(8);
		bTree.insert(7);
		bTree.insert(20);
		bTree.insert(25);
		bTree.insert(15);
		bTree.insert(23);
		bTree.insert(22);
		bTree.insert(24);
		bTree.preOrder();

		System.out.println("Delete the root again when the rightmost node has a left child");	
		bTree.delete(30);
		bTree.preOrder();
		
     }
}
