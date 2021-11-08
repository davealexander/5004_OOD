//package organization;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

//import util.Gender;

/**
 * This class represents an employee in a supervisory role. This means that this
 * employee supervises at least one other employee
 */
public class Supervisor extends GenericEmployee {

  private List<Employee> superviseeList;

  //Supervisor constructor
  public Supervisor(String name, double pay, Gender gender) {
    //Super relates back to logic in GenericEmployee
    super(name, pay, gender);
    //Create new LinkedList superviseeList
    superviseeList = new LinkedList<Employee>();
  }


  @Override
  //addSupervisee takes in parameter of supervisor's name and the Employee that needs to be added
  public Employee addSupervisee(String supervisorName, Employee supervisee) {
    //conditional that checks to see if supervisor name exists add employee under them
    if (this.name.equals(supervisorName)) {
      this.superviseeList.add(supervisee);
      return this;
    }
    //Goes through the stack and adds the supervisee and supervisor
    for (int i = 0; i < this.superviseeList.size(); i++) {
      this.superviseeList.set(
              i,
              this.superviseeList.get(i).addSupervisee(supervisorName,
                      supervisee));
    }
    return this;
  }
  
  @Override
  //Removes supervisee under supervisor. similar logic to add supervisee
  public Employee removeSupervisee(String supervisorName, Employee supervisee) {
    if (this.name.equals(supervisorName)) {
      this.superviseeList.remove(supervisee);
      return this;
    }
    for (int i = 0; i < this.superviseeList.size(); i++) {
      this.superviseeList.set(
              i,
              this.superviseeList.get(i).removeSupervisee(supervisorName,
                      supervisee));
    }
    return this;
  }
  

  @Override
  //Counts the number of Employees in the list
  public int count(Predicate<Employee> condition) {
    //creates a stream from superviseeList
    Stream<Employee> stream = this.superviseeList.stream();
    //returns the sum of Employees in the list as an integer
    return this.superviseeList.stream()
                   .mapToInt(b -> b.count(condition))
                   .sum()
           + super.count(condition);
  }

  @Override
  //Sends all employees to a List object of type Employee
  public List<Employee> toList() {
    List<Employee> result = new ArrayList<Employee>();
    result.add(this);
    for (Employee e : superviseeList) {
      result.addAll(e.toList());
    }
    return result;
  }
  
  @Override
  //Sends Employees to list if it meets predicate
  public List<Employee> toList(Predicate<Employee> predicate) {
    List<Employee> result = new ArrayList<Employee>();
    
	if(predicate.test(this))result.add(this);
	
    for (Employee e : superviseeList) {
      result.addAll(e.toList(predicate));
    }
    return result;
  }


  public String toString(){
    String result = super.toString();

    for(Employee temp : superviseeList){
      result += temp.toString() + "\n";
    }
    return result;
  }
  //Prints out Supervisor and Employees
  public void printEmployees()
  {
	  System.out.println("SUPERVISOR " + this);
	  
	  for (Employee e : superviseeList)
	  {
		  e.printEmployees();
	  }
  }
}