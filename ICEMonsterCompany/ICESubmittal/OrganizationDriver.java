package organization;

class OrganizationDriver
{
	public static void main(String [] args)
	{
		//Create some employees to play with
		NonManagerEmployee m1 = new NonManagerEmployee("Bob the undfeated", 300.00, Gender.Male);
		NonManagerEmployee m2 = new NonManagerEmployee("Gorg the smelly", 350.00, Gender.Female);
		NonManagerEmployee m3 = new NonManagerEmployee("Nix the ugly", 50.00, Gender.Male);
		NonManagerEmployee m4 = new NonManagerEmployee("Fredick the killer", 550.00, Gender.Male);
		NonManagerEmployee m5 = new NonManagerEmployee("Sue", 1000.00, Gender.Female);
		NonManagerEmployee m6 = new NonManagerEmployee("Hydra the sneaky", 300.00, Gender.Male);
		NonManagerEmployee m7 = new NonManagerEmployee("Gin the drunk", 300.00, Gender.Male);
		NonManagerEmployee m8 = new NonManagerEmployee("Lin the determined", 300.00, Gender.Female);
		ContractEmployee m9 = new ContractEmployee("Blarg the big", 300.00, Gender.Female,31,10,2020);
		
		//Generate the organization
		OrganizationImpl MonsterCorp = new OrganizationImpl("Ug the Terrible", 300000.00,Gender.UnDisclosed);
		

		//test the print
		//MonsterCorp.printEmployees();
		System.out.println(MonsterCorp);

		

		//add a single employee test
		MonsterCorp.addEmployee(m1,"Ug the Terrible");
		//MonsterCorp.printEmployees();
		System.out.println(MonsterCorp);

		

		//Create a hierarchy and test
		MonsterCorp.addEmployee(m2, "Ug the Terrible");
		MonsterCorp.addEmployee(m3,m1.getName());
		MonsterCorp.addEmployee(m4,m2.getName());
		MonsterCorp.addEmployee(m5,m2.getName());
		MonsterCorp.addEmployee(m6,m4.getName());
		MonsterCorp.addEmployee(m7,m4.getName());
		MonsterCorp.addEmployee(m8,m5.getName());
		MonsterCorp.addEmployee(m9,m5.getName());
		//MonsterCorp.printEmployees();

		System.out.println(MonsterCorp);
		
		//System.out.println(MonsterCorp.getSize());
		
		//System.out.println(MonsterCorp.getSize(m->m.getAnnualPay()==300.00));
		
		//System.out.println(MonsterCorp.allEmployees());
		
		//System.out.println(MonsterCorp.allEmployees(m->!(m.getName().contains("the"))));
		

		System.out.println("m1 Supervisor : " + MonsterCorp.getSupervisor(m1).getName());
		System.out.println("m2 Supervisor : " + MonsterCorp.getSupervisor(m2).getName());
		System.out.println("m3 Supervisor : " + MonsterCorp.getSupervisor(m3).getName());
		System.out.println("m4 Supervisor : " + MonsterCorp.getSupervisor(m4).getName());
		System.out.println("m5 Supervisor : " + MonsterCorp.getSupervisor(m5).getName());
		System.out.println("m6 Supervisor : " + MonsterCorp.getSupervisor(m6).getName());
		System.out.println("m7 Supervisor : " + MonsterCorp.getSupervisor(m7).getName());
		System.out.println("m8 Supervisor : " + MonsterCorp.getSupervisor(m8).getName());
		System.out.println("m9 Supervisor : " + MonsterCorp.getSupervisor(m9).getName());

		
		
		/*
		System.out.println("Before : \n" + MonsterCorp);
		
		MonsterCorp.removeEmployee(m5,MonsterCorp.getSupervisor(m5).getName());
		
		System.out.println("After : \n" + MonsterCorp);
		
		System.out.println("m8 : " + MonsterCorp.getSupervisor(m8).getName());
		*/
	}
	
}