//Employee Class
//Authors; Devon Stedronsky & Patrick Lee Walker
// Date last modified: 10-4-2017

//Abstract class extended with faculty and staff subclasses
//Properties: Name, ID number
//Methods: getName(), getID(), toString(), compareTo()
//Extends and overrides Comparable compareTo method to compare total salary.

import java.util.Arrays;

public abstract class Employee implements Comparable {

 //Instance variables
 private int ID = 1;
 private String name;
 private static int nextID = 1; 

 //Default employee object creation
 protected Employee(String name) {
  this.name = name;
  this.ID = nextID;
  nextID ++;
 }

 //Super toString method including just name an ID
 public String toString() {
  String output = "Name: " + name + " ID: " + ID;
  return output;
 }

 //CompareTo uses the get Salary method to compare the total yearly salary of any two employees
 //returns -1 for the caller less than, 0 for equal to, or 1 for greater than the argument object
 public int compareTo(Employee emp) {
  double salary1 = this.getSalary();
  double salary2 = emp.getSalary();
  if (salary1 < salary2) {
   return -1;
  }
  if (salary1 == salary2) {
   return 0;
  }
  else {
   return 1;
  }
 }

 //Abstract get salary method
 public abstract double getSalary();

 //TESTING MAIN
 public static void main(String[] args) {

  //Employee emp1 = new Employee("TestName");

  Employee[] arr = new Employee[5];

  arr[0] = new Faculty("fac1", 70000, 10000);
  arr[1] = new Faculty("fac2", 60000 , 20000);
  arr[2] = new Faculty("fac3", 30000 , 5000);
  arr[3] = new Staff("staff4", 10.00 , 40);
  arr[4] = new Staff("staff5", 12.00 , 50);

  System.out.println("Before Sorting:");
  for (int i = 0; i < arr.length; i++) {
   System.out.println(arr[i].toString() + "\nTotal Salary:" + arr[i].getSalary()); 
  }

  Arrays.sort(arr);
  System.out.println("After Sorting:");
  for (int i = 0; i < arr.length; i++) {
   System.out.println(arr[i].toString()); 
  }

  System.out.println(arr[0].compareTo(arr[2]));
  System.out.println(arr[4].compareTo(arr[2]));
  System.out.println(arr[0].compareTo(arr[1]));

 }
}

