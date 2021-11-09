//package organization;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

//import util.Gender;

/**
 * This class represents the data and operations of any employee. It defines
 * all the operations that either ought to be common to all implementations,
 * or have a reasonable default to be overridden by them.
 */

//Abastract Class Generic Employee
public abstract class GenericEmployee implements Employee {
  //Variables make a promise that all classes that extend Generic Employee will return name, pay, and gender
  protected String name;
  protected double pay;
  protected Gender gender;

//GenericEmployee constructor.
  public GenericEmployee(String name,double pay, Gender gender) {
    this.name = name;
    this.pay = pay;
    this.gender = gender;
  }

//Getters
  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public Gender getGender() {
    return this.gender;
  }

  @Override
  public double getAnnualPay() {
    return this.pay;
  }


  /**
   * By default, there is no end date for an employee. Only contract
   * employees have an actual end date.
   * @return
   */
  @Override
  public String getEmploymentEndDate() {
    return "XXXXXXXX";
  }

  //A count method that if an employee occupies a node return 1 if not return 0
  @Override
  public int count(Predicate<Employee> condition) {
    if (condition.test(this)) {
      return 1;
    }
    return 0;
  }

  //toList creates a new ArrayList and adds employee(s) to the list and returns the result of the list.
  @Override
  public List<Employee> toList() {
    List<Employee> result = new ArrayList<Employee>();
    result.add(this);
    return result;
  }

  //This is an overload method that does the same as above but adds in logic for a predicate test making sure
  //what is passed in is an employee.
  @Override
  public List<Employee> toList(Predicate<Employee> predicate) {
    List<Employee> result = new ArrayList<Employee>();
	
	if(predicate.test(this))result.add(this);
	
    return result;
  }
  
  public String toString()
  {
	  return "Name : " + name + "\nGender : " + gender + "\nPay : " + pay + "\n \n";
  }
  
}