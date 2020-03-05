/* Name: MyLinkedList
 * Authors: Devon Stedronsky && Patrick Lee Walker
 * Date Last Modified: 11/09/2017
 * Description: This custom singly linked list class mimics the Java collections framework.
 * This generic class uses connected nodes containing pointers and parameterized data.
 * 
 */

public class MyLinkedList<T> {
	// the Node class is a private inner class used (only) by the LinkedList class
	private class Node {
		private T data;
		private Node next;

		public Node(T a, Node n) {
			data = a;
			next = n;
		}
	}

	private Node first;
	private int length;  // to enable an O(1) size method


	public MyLinkedList() {
		first = null;
		length = 0;  // added after considering the size() method
	}
	
	public boolean isEmpty() {
		return (first == null);
	}

	public void addFirst(T d) {   
		first = new Node(d,first);
		length++;
	}

	public int size() {
		return length;
	}

	public void clear() {
		first = null;
		length = 0;
	}

	public boolean contains(T value) {
		for (Node curr = first; curr != null; curr = curr.next) {
			if (value.equals(curr.data)) {
				// this implies that the data must have an overridden .equals() method!
				return true;
			}
		}
		return false;
	}

	public Object get(int index) {
		if (index < 0 || index >= length) {
			System.out.println("Index of " + index + " out of range");
			return null;
		}

		Node curr = first;
		for (int i = 0; i < index; i++)
			curr = curr.next;
		return curr.data;
	}

	public boolean remove(T m) {
		if (isEmpty())
			return false;

		if (m.equals(first.data)) {
			first = first.next;
			length--;
			return true;
		}

		Node curr = first;
		while (curr.next != null) {
			if (m.equals(curr.next.data)) {
				// this implies that the data must have an overridden equals() method!
				curr.next = curr.next.next;
				length--;
				return true;
			}
			curr = curr.next;
		}
		return false;
	}

	public String toString() {
		StringBuilder result = new StringBuilder();  //String result = "";

		for (Node curr = first; curr != null; curr = curr.next)
			result.append(curr.data + "->");  //result = result + curr.data + "->";

		result.append("[null]");
		return result.toString();   //return result + "[null]";
	}

	// ------------------------  A5 methods start here ------------------------

	//Returns object in the first node; prints error message and returns null if empty
	public T getFirst() {

		if (this.isEmpty() == true) {
			return null;
		}
		
		return (T) first.data;
	}

	//Returns object in the last node; prints error message and returns null if empty
	public T getLast() {
		
		if (this.isEmpty() == true) {
			return null;
		}
		
		return (T) this.get(length - 1);
	}

	//Adds a node containing value to the end of the list
	public void add(T value)	{

		//Create node
		Node n = new Node(value, null);

		if (first == null) {
			first = n;
			length++;
			return;
		}

		//Locate end of list
		Node currNode = first;
		while (currNode.next != null)	{
			currNode = currNode.next;
		}

		//Add element
		currNode.next = n;
		length++;
		return;
	}

	//Replaces data of the node at the index specified with new value and returns the old value.
	//Prints an error message and returns null is index is out of range
	public T set(int index, T newValue) {
		//Out of range error could be replaced with null pointer try/catch
		if (index >= length) {
			System.out.println("Error: Index out of range.");
			return null;
		}

		Node currNode = first;
		for (int i = 0; i < index; i++) {
			currNode = currNode.next;
		}

		Object oldData = currNode.data;
		currNode.data = newValue;
		return (T) oldData;
	}
	
	//Adds a node containing value after the index specified. Prints error message is index is out of range.
	public void addAfter(int index, T value) {

		//Out of range error could be replaced with null pointer try/catch
		if (index >= length) {
			System.out.println("Error: Index out of range.");
			return;
		}

		//Accessing current and next node at index value
		Node currNode = first;
		Node nextNode = currNode.next;
		for (int i = 0; i < index; i++) {
			currNode = currNode.next;
			nextNode = currNode.next;
		}

		//Adding new node after the specified index
		Node n = new Node(value, nextNode);
		currNode.next = n;
		length ++;
		return;
	}

	//Returns the index of the last node which contains value. Returns -1 if it does not occur.
	public int lastIndex(T value) {

		Node currNode = first;
		int match = -1;

		for (int i = 0; i < length; i++) {
			if (currNode.data == value) {
				match = i;
			}
			currNode = currNode.next;
		}

		return match;
	}

	//Returns a new list that is a shallow copy of the list calling the method.
	public MyLinkedList<T> clone() {
		MyLinkedList<T> newList = new MyLinkedList<T>();
		Node currNode = first;
		
		for (int i = 0; i < length; i ++) {
			newList.add(currNode.data);
			currNode = currNode.next;
		}
		
		return newList;
	}

	//Removes all nodes containing value and does nothing otherwise
	public void removeAll(T value) {
		while (this.remove(value) == true) {
			this.remove(value);
		}
		return;
	}

	/*This method overrides the equals method (found in the Object class).
	 *The method returns true if and only if both lists have the same size and all
     *corresponding pairs of elements in the two lists are equal.
	 */
	public boolean equals(Object o) {
		MyLinkedList<T> list = (MyLinkedList<T>)o;
		
		if (this.length != list.length) {
			return false;
		}
		
		for (int i = 0; i < length; i++) {
			if (list.get(i) != this.get(i)) {
				return false;
			}
		}
		return true;
	}

	/*This method splits the original list in half. The original list will continue to reference the
    front half of the original list and the method returns a reference to a new list that stores
    the back half of the original list. If the number of elements is odd, the extra element
    should remain with the front half of the list. If the list is empty or only contains one element, 
    a 0 length null list is returned and the original list is unchanged.
	 */
	public MyLinkedList<T> split() {
	
		if (this.isEmpty() == true) {
			return this.clone();
		}
		
		MyLinkedList<T> backList = new MyLinkedList<T>();
		MyLinkedList<T> frontList = new MyLinkedList<T>();
		Node currNode = first;
		
		int g = length;
		
		//ODD LENGTH LIST
		if (g%2 != 0) {
		for (int i = 0; i < (g / 2) + 1; i++) {
			frontList.add(currNode.data);
			currNode = currNode.next;
		}
		
		for (int i = (g / 2) + 1; i < g; i++) {
			backList.add(currNode.data);
			currNode = currNode.next;
		}
		}
		
		//EVEN LENGTH LIST
		if (g%2 == 0) {
			for (int i = 0; i < (g / 2); i++) {
				frontList.add(currNode.data);
				currNode = currNode.next;
			}
			
			for (int i = (g / 2); i < g; i++) {
				backList.add(currNode.data);
				currNode = currNode.next;
			}
		}
		
		this.clear();
		Node n = frontList.first;
		for (int i = 0; i < frontList.length; i++) {
			this.add(n.data);
			n = n.next;
		}
		
		return backList;
	}

	//Replaces each element in the list with adjacent copies of itself
	public void doubler() {
		Node currNode = first;
		//Node nextNode = currNode.next;
		for (int i = 0; i < length; i = i + 2) {
			this.addAfter(i, currNode.data);
			currNode = currNode.next.next;	
		}
		return;
	}

	//Returns a new sublist starting at index i and ending at index j-1
	//Returns null and prints an error if indices are invalid or if list is initially empty
	public MyLinkedList<T> sublist(int i, int j) {

		if (i >= length || j > length || i < 0 || j < i) {
			System.out.println("Invalid Indicies");
			return null;
		}
		
		MyLinkedList<T> sublist = new MyLinkedList<T>();

		for (int k = i; k < j; k++) {
			sublist.add((T) this.get(k));
		}
		
		return sublist;
	}

	
	
	//TESTING MAIN -- See ListTest.java//
	public static void main(String[] args) {
		ListTest.main(args);;
		
	}
}