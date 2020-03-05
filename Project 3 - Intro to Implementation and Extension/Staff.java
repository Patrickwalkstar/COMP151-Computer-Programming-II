//Faculty Class
//Authors; Devon Stedronsky & Patrick Lee Walker
// Date last modified: 10-4-2017

//Properties: Name, ID number, hourlyWage, hoursPerWeek
//Methods: toString(), getSalary()

class Staff extends Employee {
 
 //Instance variables
 private double hourlyWage;
 private double hoursPerWeek;
 
 //Constructor
 protected Staff(String name, double hourlyWage, double hoursPerWeek) {
  super(name);
  this.hourlyWage = hourlyWage; 
  this.hoursPerWeek = hoursPerWeek;
 }

 //Calculating total salary assuming 52 work weeks
 @Override
 public double getSalary() {
  // TODO Auto-generated method stub
  double totalSalary = this.hourlyWage * this.hoursPerWeek * 52;
  return totalSalary;
 }

 //Adding additional information to toString() method
 @Override
 public String toString() {
  String output = super.toString() + " Hourly Wage: $" + this.hourlyWage + " Hours per Week: $" + this.hoursPerWeek;
  return output;
 }

 @Override
 public int compareTo(Object o) {
  // TODO Auto-generated method stub
  return 0;
 }
 
}