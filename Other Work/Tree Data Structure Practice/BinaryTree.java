import java.util.Queue; 		// used in levelOrder()
import java.util.ArrayDeque;	// used in levelOrder()

public class BinaryTree {
    // Root node pointer. Will be null for an empty tree. 

    private Node root;

    /* 
    --Node-- 
    The binary tree is built using this nested node class. 
    Each node stores one data element, and has left and right 
    sub-tree pointer which may be null. 
    The node is a "dumb" nested class -- we just use it for 
    storage; it does not have any methods. 
    */
    public static class Node {

        Node left;
        Node right;
        int data;

        Node(int newData) {
            left = null;
            right = null;
            data = newData;
        }
    }

    /** 
    	Creates an empty binary tree -- a null root pointer. 
    */
    public BinaryTree() {
        root = null;
    }

	// Task 3	
	public BinaryTree(int data) {
		root = new Node(data);
	}
	
	// Task 4
	public boolean isEmpty() {
		return root == null;
	}
	
	public void clear() {
		root = null;
	}

	/** 
    	Inserts the given data into the binary tree. 
	    Uses a recursive helper. 
    */
    public void insert(int data) {
        root = insert(root, data);
    }

    /** 
    	Recursive insert -- given a node pointer, recur down and 
	    insert the given data into the tree. Returns the new 
	    node pointer (the standard way to communicate 
	    a changed pointer back to the caller). 
    */
    private Node insert(Node node, int data) {
        if (node == null) {
            node = new Node(data);
        } else {
            if (data <= node.data) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }
        }

        return (node); // in any case, return the new pointer to the caller 
    }


    /** 
    	Returns the number of nodes in the tree. 
	    Uses a recursive helper that recurs 
	    down the tree and counts the nodes. 
    */
    public int size() {
        return (size(root));
    }

	// Task 5
    private int size(Node node) {
		if (node == null)
			return 0;
		else
			return 1 + size(node.left) + size(node.right);
    }

    /** 
    	Returns true if the given target is in the binary tree. 
	    Uses a recursive helper. 
    */
    public boolean search(int data) {
        return (search(root, data));
    }

    /** 
    	Recursive search  -- given a node, recur 
    	down searching for the given data. 
    */
    private boolean search(Node node, int data) {
        if (node == null) {
            return (false);
        }

        if (data == node.data) {
            return (true);
        } else if (data < node.data) {
            return (search(node.left, data));
        } else {
            return (search(node.right, data));
        }
    }

    /** 
    	Prints the node values in the "inOrder" order. 
    	Uses a recursive helper to do the traversal. 
    */
    public void inOrder() {
        inorderTree(root);
        System.out.println();
    }

    private void inorderTree(Node node) {
    		if ( node == null )
    			return;
    		else {
    			inorderTree(node.left);
    			System.out.println(node.data);
    			inorderTree(node.right);
    		}
    }


    /** 
    	Prints the node values in the "preOrder" order. 
    	Uses a recursive helper to do the traversal. 
    */
    public void preOrder() {
        preOrder(root);
        System.out.println();
    }

	// Task 6
    public void preOrder(Node node) {
		if ( node == null )
			return;
		else {
			System.out.println(node.data);
			preOrder(node.left);
			preOrder(node.right);
		}
    }


    /** 
    Prints the node values in the "postOrder" order. 
    Uses a recursive helper to do the traversal. 
     */
    public void postOrder() {
        postOrder(root);
        System.out.println();
    }

	// Task 7 
    public void postOrder(Node node) {
		if ( node == null )
			return;
		else {
			postOrder(node.left);
			postOrder(node.right);
			System.out.println(node.data);
		}
    }



    /** 
    Prints the node values in the "levelOrder" order. 
    Uses a helper to do the traversal. 
     */
    public void levelOrder() {
        levelOrder(root);
        System.out.println();
    }

    public void levelOrder(Node node) {

        if (node != null) {

            Queue<Node> q = new ArrayDeque<Node>();
            q.add(node);

            while (q.size() != 0) {

                Node currentNode = q.remove();
                System.out.print(currentNode.data + "  ");

                if (currentNode.left != null) {
                    q.add(currentNode.left);
                }

                if (currentNode.right != null) {
                    q.add(currentNode.right);
                }
            }
        }
    }

     /** 
    	Changes the tree into its mirror image.    
	    Uses a recursive helper that recurs over the tree, 
	    swapping the left/right pointers. 
     */
    public void mirror() {
		mirror(root);
    }

	// Task 10
    private void mirror(Node node) {
        if(node == null)
			return;
		else {
			mirror(node.left);
			mirror(node.right);
			
			Node temp = node.left;
			node.left = node.right;
			node.right = temp;
		}
	}
    
	public boolean delete(int x) {
		// Locate the node to be deleted
		// Keep a reference to the parent node as well 
		Node parent = null;
		Node current = root;
		
		while (current != null) {
			if ( x < current.data ) {
				parent = current;
				current = current.left;
			}
			else if ( x > current.data ) {
				parent = current;
				current = current.right;
			}
			else
				break; // Element is in the tree pointed at by current
		}

		// Confirm that the previous loop found the element to delete
		// Return if the element is not found
		if (current == null)
			return false; 

		// Case: The element to delete has no left child
		if (current.left == null) {
			// Connect the parent with the right child of the current node
			
			// Special case if the node to delete is the root 
			if (parent == null) {
				root = current.right;
			}
			else {
				if ( x < parent.data )
					parent.left = current.right;
				else
					parent.right = current.right;
			}
		}
		else {
			// Case: The current node has a left child
			// Locate the rightmost node in the left subtree of
			// the current node and also its parent
 			Node parentOfRightMost = current;
			Node rightMost = current.left;

			while (rightMost.right != null) {
				parentOfRightMost = rightMost;
				rightMost = rightMost.right; // Keep going to the right
			}

			// Replace the element in current by the element in rightMost
			current.data = rightMost.data;

			// Eliminate rightmost node
			if (parentOfRightMost.right == rightMost)
				parentOfRightMost.right = rightMost.left;
			else {
				// Special case: parentOfRightMost == current
				parentOfRightMost.left = rightMost.left;     
			}
		}

		return true; // Element deleted successfully
	}
}