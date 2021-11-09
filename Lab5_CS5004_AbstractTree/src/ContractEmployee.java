//package organization;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//import util.Gender;


/**
 * This class represents an employee who works on a term-limited contract
 * with the organization. Contract employees cannot manage
 * other employees within this organization.
 */
public class ContractEmployee extends NonManagerEmployee {
  private LocalDate contractEndDate;

  //Constructor for ContractEmployee
  public ContractEmployee(String name, double pay, Gender gender, int date, int
   month, int year) throws IllegalArgumentException{
    super(name, pay, gender);
    //validate our date
    try {
      contractEndDate = LocalDate.of(year, month, date);
    }
    catch (DateTimeException e) {
      throw new IllegalArgumentException("Invalid contract end date");
    }
  }

  //Getter for End date of employment for employee
  @Override
  public String getEmploymentEndDate() {
    return DateTimeFormatter.ofPattern("MMddyyyy").format(contractEndDate);
  }

  //A print method for this type of employee.
  public void printEmployees()
  {
	  System.out.print("CONTRACTOR ");
	  super.printEmployees();
	  
  }
}