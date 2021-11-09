//package organization;

//import util.Gender;

/**
 * This class represents an internal employee who has no managerial
 * responsibilities.
 */
public class InternalEmployee extends NonManagerEmployee {
  //Constructor for an internal Employee.
  public InternalEmployee(String name, double pay, Gender gender) {
    super(name, pay, gender);
  }
}