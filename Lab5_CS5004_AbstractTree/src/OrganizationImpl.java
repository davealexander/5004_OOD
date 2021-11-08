/*
This class has to be redesigned to use the generic tree node system instead of the former system. 
I've included a backup of this file in case it is useful to you. 
You'll need to populate the body based on the module and add the requested additional functionality.
*/


import java.util.List;

public class OrganizationImpl implements Organization {
    private TreeNode<Employee> root;


    public OrganizationImpl(String nameCEO, double pay, Gender gender) {
        root = new LeafNode<>(new InternalEmployee(nameCEO,pay,gender));
    }

    @Override
    public void addEmployee(String name, double pay, Gender gender, String supervisorName) {
        Employee newEmployee = new InternalEmployee(name,pay,gender);
        TreeNode<Employee> newNode = new LeafNode<>(newEmployee);
        root = root.addChild(e->e.getName().equals(supervisorName),newNode);
    }

    @Override
    public void addEmployee(Employee newEmployee, String supervisorName) {
        TreeNode<Employee> newNode = new LeafNode<>(newEmployee);
        root = root.addChild(e->e.getName().equals(supervisorName),newNode);
    }

    @Override
    public void addContractEmployee(String name, double pay, Gender gender, int endDate, int endMonth, int endYear, String supervisorName) {
        Employee newEmployee = new ContractEmployee(name,pay,gender,endDate,
                endMonth,endYear);
        TreeNode<Employee> newNode = new LeafNode<>(newEmployee);
        root = root.addChild(e->e.getName().equals(supervisorName),newNode);
    }

    @Override
    public int getSize() {
        //Converts Tree of employees into an integer and counts per node. Will return the size of TreeNodes
        return root.map(e-> Integer.valueOf(1)).reduce(0,(a, b)->a+b);
    }

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

    @Override
    public List<String> allEmployees() {
        return root.map(e->e.getName()).toList();
    }

    public String toString(){
        return root.toString();
    }
}