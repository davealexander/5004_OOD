/*
This class has to be redesigned to use the generic tree node system instead of the former system. 
I've included a backup of this file in case it is useful to you. 
You'll need to populate the body based on the module and add the requested additional functionality.
*/

import java.util.List;
import java.util.function.Predicate;

public class OrganizationImpl implements Organization {
    private TreeNode<Employee> root;

    //OrganizationImpl construtor
    public OrganizationImpl(String nameCEO, double pay, Gender gender) {
        root = new LeafNode<>(new InternalEmployee(nameCEO,pay,gender));
    }

    //adds an employee with required parameters to the Employee Tree
    //Employee is placed under a supervisor determined by predicate.
    @Override
    public void addEmployee(String name, double pay, Gender gender, String supervisorName) {
        Employee newEmployee = new InternalEmployee(name,pay,gender);
        TreeNode<Employee> newNode = new LeafNode<>(newEmployee);
        root = root.addChild(e->e.getName().equals(supervisorName),newNode);
    }

    //adds an employee object to the Tree via a leafnode.
    //Employee is created under supervisor which is a predicate.
    @Override
    public void addEmployee(Employee newEmployee, String supervisorName) {
        TreeNode<Employee> newNode = new LeafNode<>(newEmployee);
        root = root.addChild(e->e.getName().equals(supervisorName),newNode);
    }

    //adds a contract employee by creating a new contract employee and sends them to a leafnode.
    //The location of leafnode is determined by a predicate of supervisor name and creates a new node there.
    @Override
    public void addContractEmployee(String name, double pay, Gender gender, int endDate, int endMonth, int endYear, String supervisorName) {
        Employee newEmployee = new ContractEmployee(name,pay,gender,endDate,
                endMonth,endYear);
        TreeNode<Employee> newNode = new LeafNode<>(newEmployee);
        root = root.addChild(e->e.getName().equals(supervisorName),newNode);
    }

    //getSize method provides number of nodes within the heirarchy
    @Override
    public int getSize() {
        //Converts Tree of employees into an integer and counts per node. Will return the size of TreeNodes
        return  root.map(e-> Integer.valueOf(1)).reduce(0,(a, b)->a+b);
    }

    /*
    Method overload of getSize. This method takes in a predicate condition that checks if the pay is 300.
    If the pay is == 300, it adds to the counter of monsters that have a pay of 300.
     */
    public int getSize(Predicate<Employee> pay){
        //returns number of monsters
        return root.map(m->{
            //predicate condition if m's annualpay is == 300 increment by 1. If not, increment by 0
            if(m.getAnnualPay() == 300){
                return Integer.valueOf(1);
            }
            else{
                return Integer.valueOf(0);
            }
            //reduce starts a counter at 0 and then adds a = 1 or b = 0 together and returns the result.
        }).reduce(0,(a,b)->a+b);
    }

    //Method provides size of heirarchy based off of gender
    @Override
    public int getSizeByGender(Gender gender) {
        //Calls the map method on root
         return root.map(e->
         {
             //if the parameter of gender matches to the employee, assign node value of 1;
             if (e.getGender() == gender){
                 return Integer.valueOf(1);
             }
             //if the parameter of gender does not match assign node value of 0;
             else{
                 return Integer.valueOf(0);
             }
         //Reduces the values down to one integer and combines all the values of the nodes
         }).reduce(0,(a,b)->a+b);
    }

    //allEmployees method that uses map method to send heirarchy to a list format
    @Override
    public List<String> allEmployees() {
        return root.map(e->e.getName()).toList();
    }

    //method that prints out all information of employees added to organization
    public void printEmployees(){
        System.out.println(root.toList().toString());
    }

    //method that prints out allEmployees names. AllEmployees sends heirarchy to list structure
    public void printAllEmployees(){
        System.out.println(allEmployees().toString());
    }
}