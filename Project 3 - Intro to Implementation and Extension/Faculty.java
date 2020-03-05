//Faculty Class
//Authors; Devon Stedronsky & Patrick Lee Walker
// Date last modified: 10-4-2017

//Properties: [Name, ID number] yearSalary, summerSalary
//Methods: toString(), getSalary()

class Faculty extends Employee {

 //Instance Variables
 private double yearSalary;
 private double summerSalary;

 //Constructor
 protected Faculty(String name, double yearSalary, double summerSalary) {
  super(name);
  this.yearSalary = yearSalary;
  this.summerSalary = summerSalary;

 }

 //Calculates total Salary
 @Override
 public double getSalary() {
  // TODO Auto-generated method stub
  double totalSalary = this.yearSalary + this.summerSalary;
  return totalSalary;
 }

 //Adding additional information to toString() method
 @Override
 public String toString() {
  String output = super.toString() + " Academic Salary: $" + this.yearSalary + " Summer Salary: $" + this.summerSalary;
  return output;
 }

 @Override
 public int compareTo(Object o) {
  // TODO Auto-generated method stub
  return 0;
 }
 
 

}
