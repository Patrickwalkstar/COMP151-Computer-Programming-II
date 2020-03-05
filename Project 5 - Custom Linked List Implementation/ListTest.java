import java.math.RoundingMode;
/*Name: ListTest
 * Authors: Devon Stedronsky && Patrick Lee Walker
 * Date Last Modified: 11-15-2017
 * Description: This test file is meant to test the 12 functions developed
 * for the MyLinkedList generic class (Assignment 5)
 */
public class ListTest
{
    public static void main(String[] args)
    {
    	
        MyLinkedList<String> list0 = new MyLinkedList<String>();
        MyLinkedList<String> list1 = new MyLinkedList<String>();
        MyLinkedList<String> list2 = new MyLinkedList<String>();
        
        list1.addFirst("node1");
        System.out.println("1-element list: " + list1);
        list2.addFirst("node2"); list2.addFirst("node1");
        System.out.println("2-element list: " + list2);
        
        System.out.println("\nTesting getFirst...");
        System.out.println(list0.getFirst());
        System.out.println(list1.size() + " " + list1);
        System.out.println(list1.getFirst().equals("node1")?"PASSED":"**FAILED**");
        System.out.println(list2.size() + " " + list2);
        System.out.println(list2.getFirst().equals("node1")?"PASSED":"**FAILED**");
        
        System.out.println("\nTesting getLast...");
        System.out.println(list0.getLast());
        System.out.println(list1.size() + " " + list1);
        System.out.println(list1.getLast().equals("node1")?"PASSED":"**FAILED**");
        System.out.println(list1.size() + " " + list1);
        System.out.println(list2.size() + " " + list2);
        System.out.println(list2.getLast().equals("node2")?"PASSED":"**FAILED**");
        System.out.println(list2.size() + " " + list2);
      
        System.out.println("\nTesting add...");
        MyLinkedList<String> list3 = new MyLinkedList<String>();
        MyLinkedList<String> list4 = new MyLinkedList<String>();
        list3.add("node1"); list3.add("node2"); list3.add("node3");
        System.out.println("3-element list: " + list3);
        list4.add("node1"); list4.add("node2"); list4.add("node3"); list4.add("node4");
        System.out.println("4-element list: " + list4);
        
        System.out.println("\nTesting set...");
        MyLinkedList<String> test = new MyLinkedList<String>();
        System.out.println("  empty list test = " + ((test.set(2,"bad") == null)?"PASSED":"**FAILED**"));
        test.addFirst("Mark");
        test.addFirst("Sohaib");
        test.addFirst("Salman");
        System.out.println("  return value test = " + ((test.set(1,"Nora")).equals("Sohaib")?"PASSED":"**FAILED**"));
        System.out.println("  non-empty test = " + ((test.get(0).equals("Salman") && test.get(1).equals("Nora") &&
                           test.get(2).equals("Mark"))?"PASSED":"**FAILED**"));
  
        System.out.println("\nTesting addAfter...");
        MyLinkedList<String> other = new MyLinkedList<String>();
        other.add("one");
        other.add("two");
        other.add("three");
        other.add("four");
        System.out.println(other.size() + " " + other);
        other.addAfter(2,"three.5");
        System.out.println((other.get(3).equals("three.5")?"PASSED":"**FAILED**"));
        System.out.println(other.size() + " " + other);
        
        System.out.println("\nTesting lastIndex...");
        System.out.println((test.lastIndex("Salman")==0)?"PASSED":"**FAILED**");
        test.addFirst("Mark");
        test.addFirst("Nora");
        System.out.println(test);
        System.out.println((test.lastIndex("Mark")==4)?"PASSED":"**FAILED**");
        System.out.println((test.lastIndex("Nora")==3)?"PASSED":"**FAILED**");
        list0.clear();
        System.out.print("Empty List Test = ");
        System.out.print(list0.lastIndex("Habib") == -1?"PASSED":"**FAILED**");
        System.out.print("\nDoes Not Occur Test = ");
        System.out.print(test.lastIndex("Habib") == -1?"PASSED":"**FAILED**");
        

        System.out.println("\n\nTesting clone...");
        MyLinkedList<String> empty = new MyLinkedList<String>();
        list1 = empty.clone();
        System.out.println("  empty list test = " + (list1.isEmpty()?"PASSED":"**FAILED**"));
        MyLinkedList<String> another = other.clone();
        System.out.println("another: " + another.size() + " " + another);
        System.out.println("other: " + other.size() + " " + other);
        System.out.println("  making sure nodes not shared...");
        System.out.print("Clones are equal before manipulation = ");
        System.out.print(other.equals(another)?"PASSED":"**FAILED**");
        other.remove("two");
        System.out.println("\nother: " + other.size() + " " + other);
        System.out.println("another: " + another.size() + " " + another);
        System.out.print("Clones are not equal after manipulation = ");
        System.out.print(!other.equals(another)? "PASSED":"**FAILED**");

        System.out.println("\n\nTesting removeAll...");
       another.add("one");
       another.add("two");
       another.add("one");
       another.addAfter(3, "one");
       System.out.println(another + "\n   Remove all ones from this list: ");
       another.removeAll("one");
       System.out.println(another);
       System.out.println("   Now remove the twos: ");
       another.removeAll("two");
       System.out.println(another);
       System.out.println("   Try removing what isn't there: ");
       another.removeAll("five");
       System.out.println(another);
       System.out.println("   Removing single elements using removeAll: ");
       another.removeAll("three.5");
       System.out.println(another);
       another.removeAll("three");
       System.out.println(another);
       another.removeAll("four");
       System.out.println(another);
       System.out.println("   Try removing from empty list: ");
       another.removeAll("one");
       System.out.println(another);
       

        System.out.println("\nTesting equals...");
        System.out.println("  reflexive test = " + (list2.equals(list2)?"PASSED":"**FAILED**"));
        MyLinkedList<String> emptyList = new MyLinkedList<String>();
        list0.clear();
        list1.clear();
        list1.add("node1");
        System.out.println("  empty list test/true = " + (emptyList.equals(list0)?"PASSED":"**FAILED**"));
        System.out.println("  empty list test1/false = " + (!emptyList.equals(list1)?"PASSED":"**FAILED**"));
        System.out.println("  empty list test2/false = " + (!list1.equals(emptyList)?"PASSED":"**FAILED**"));
        list0.add("node1");
        System.out.println("  singleton test = " + (list0.equals(list1)?"PASSED":"**FAILED**"));
        System.out.println("  subset inclusion 1/false = " + (!list1.equals(list2)?"PASSED":"**FAILED**"));
        System.out.println("  subset inclusion 2/false = " + (!list2.equals(list1)?"PASSED":"**FAILED**"));
        list0.add("node2"); list0.add("node3"); list0.add("node4");
        list0.add("node5"); list0.add("node6"); list0.add("node7");
        list4.add("node5"); list4.add("node6"); list4.add("node7");
        System.out.println("  7-element test/true = " + (list0.equals(list4)?"PASSED":"**FAILED**"));
        list0.remove("node4");
        list0.add("node5");
        System.out.println("  7-element test/false = " + (!list0.equals(list4)?"PASSED":"**FAILED**"));
        System.out.println("  7-element test/false = " + (!list4.equals(list0)?"PASSED":"**FAILED**"));

        System.out.println("\nTesting split...");
        MyLinkedList<String> result;
        list0.clear();
        list1.clear();
        list1.add("node1");
        list2.clear();
        list2.add("node1");
        list2.add("node2");
        list3.clear();
        list3.add("node1"); list3.add("node2"); list3.add("node3");
        list4.clear();
        list4.add("node1"); list4.add("node2"); list4.add("node3"); list4.add("node4");
        MyLinkedList<String> list5 = new MyLinkedList<String>();
        list5.add("node1"); list5.add("node2"); list5.add("node3"); list5.add("node4");
        list5.add("node5");
        MyLinkedList<String> list6 = new MyLinkedList<String>();
        list6.add("node1"); list6.add("node2"); list6.add("node3"); list6.add("node4");
        list6.add("node5"); list6.add("node6");
        MyLinkedList<String> list7 = new MyLinkedList<String>();
        list7.add("node1"); list7.add("node2"); list7.add("node3"); list7.add("node3");
        list7.add("node2"); list7.add("node1");
        MyLinkedList<String> list8 = new MyLinkedList<String>();
        list8.add("node1"); list8.add("node1"); list8.add("node3"); list8.add("node3");
        list8.add("node2"); list8.add("node1"); list8.add("node1");
        System.out.print("SPLIT ");
        System.out.println(list0.size() + " " + list0);
        result = list0.split();
        System.out.println("  list " + list0.size() + " " + list0);
        System.out.println("  result " + result.size() + " " + result);
        System.out.print("SPLIT ");
        System.out.println(list1.size() + " " + list1);
        result = list1.split();
        System.out.println("  list " + list1.size() + " " + list1);
        System.out.println("  result " + result.size() + " " + result);
        System.out.print("SPLIT ");
        System.out.println(list2.size() + " " + list2);
        result = list2.split();
        System.out.println("  list " + list2.size() + " " + list2);
        System.out.println("  result " + result.size() + " " + result);
        System.out.print("SPLIT ");
        System.out.println(list3.size() + " " + list3);
        result = list3.split();
        System.out.println("  list " + list3.size() + " " + list3);
        System.out.println("  result " + result.size() + " " + result);
        System.out.print("SPLIT ");
        System.out.println(list4.size() + " " + list4);
        result = list4.split();
        System.out.println("  list " + list4.size() + " " + list4);
        System.out.println("  result " + result.size() + " " + result);
        System.out.print("SPLIT ");
        System.out.println(list5.size() + " " + list5);
        result = list5.split();
        System.out.println("  list " + list5.size() + " " + list5);
        System.out.println("  result " + result.size() + " " + result);
        System.out.print("SPLIT ");
        System.out.println(list6.size() + " " + list6);
        result = list6.split();
        System.out.println("  list " + list6.size() + " " + list6);
        System.out.println("  result " + result.size() + " " + result);
        System.out.println("Checking for order of repeated data");
        System.out.println("SPLIT " + list7.size() + " " + list7);
        result = list7.split();
        System.out.println("  list " + list7.size() + " " + list7);
        System.out.println("  result " + result.size() + " " + result);
        System.out.println("SPLIT " + list8.size() + " " + list8);
        result = list8.split();
        System.out.println("  list " + list8.size() + " " + list8);
        System.out.println("  result " + result.size() + " " + result);
        
		int i = 1; 	int j = 2;	int k = 3;	int m = 4;
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		list.add(i);		list.add(j);		list.add(k);		list.add(i);		list.add(j);		list.add(k);
		System.out.println("\nTesting Doubler: " + list);
		list.doubler();
		System.out.println("After doubling: " + list.toString());
		empty.clear();
		empty.doubler();
		System.out.println("Empty List after doubling: " + empty);
		System.out.println("Testing some methods on doubled list");
		list.removeAll(j);
		list.addAfter(4, m);
		System.out.println(list);
		
		System.out.println("\nTesting Sublist: " + list.size() + "    " + list);
		System.out.println("Sublist of 0 to 5: " + list.sublist(0, 5).toString());
		System.out.println("Sublist of 2 to 7: " + list.sublist(2, 7).toString());
		System.out.println("Sublist of 6 to 9: " + list.sublist(6, 9).toString());
		System.out.println("Empty list sublist: " + empty.sublist(1, 5));
		System.out.println("bad indicies tests: " + list.sublist(20, 5) + list.sublist(1, 15) + list.sublist(-2, 5));
    }
}
