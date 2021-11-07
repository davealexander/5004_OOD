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
        return 0;
    }

    @Override
    public int getSizeByGender(Gender gender) {
        return 0;
    }

    @Override
    public List<String> allEmployees() {
        return null;
    }
}