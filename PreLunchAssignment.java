import java.util.*;

public class PreLunchAssignment {
	public static int userPrompt(Scanner sc,int x) {
		System.out.println("+------------------------------------------------------------+");
		System.out.println("Please select options from below menu");
		System.out.println("Enter 1 to add Department to Dassault Systemes");
		System.out.println("Enter 2 to print Department of Dassault Systemes");
		System.out.println("Enter 3 to remove Department of Dassault Systemes");
		System.out.println("Enter 0 to exit the program");
		System.out.println("+------------------------------------------------------------+");
		x = sc.nextInt();
		
		return x;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DassaultSystemes ds = new DassaultSystemes();
	
		while(true) {
			int userInput = 0;
			userInput = userPrompt(sc, userInput);
			switch(userInput) {
			case 1:
				System.out.println("Enter the Department Name");
				String deptName = sc.next();
				sc.nextLine();
				System.out.println("Enter the Department Location");
				String deptLocation = sc.nextLine();
				try {
					ds.addDepartment(deptName, deptLocation);
					ds.printDepartment(deptName);
				} catch (FieldEmptyException | DepartmentAlreadyTakenException e) {
					System.out.println(e.getMessage());
					System.out.println("Please try again");
					userInput = userPrompt(sc, userInput);
				}
				break;
			case 2:
				System.out.println("Enter the Department Name");
				sc.nextLine();
				deptName = sc.next();
				ds.printDepartment(deptName);
				sc.nextLine();
				break;
			case 3:
				System.out.println("Enter the Department Name");
				sc.nextLine();
				deptName = sc.next();
				ds.printDepartment(deptName);
				ds.removeDepartment(deptName);
				sc.nextLine();
				break;
			case 0:
				System.out.println("Program exited");
				return;
			}
		} 
	}
}

class FieldEmptyException extends Exception{
	public FieldEmptyException(String message) {
		super(message);
	}
}

class DepartmentAlreadyTakenException extends Exception {
	public DepartmentAlreadyTakenException(String message) {
		super(message);
	}
}

class DassaultSystemes{
	ArrayList<Department> departments;
	
	public DassaultSystemes() {
		super();
		this.departments = new ArrayList<Department>();
	}

	void addDepartment(String name,String location) throws  FieldEmptyException, DepartmentAlreadyTakenException{
		//iterate over existing departments and check if name is already taken
		for(Department depts: departments) {
			if(depts.getDeptName().equals(name)) {
				throw new DepartmentAlreadyTakenException("Department Name already taken");
			}
		}
		Department dept = new Department(name, location);
		departments.add(dept);
		System.out.println("Department " + name + " successfully added.");
	}
	
	void removeDepartment(String name) {
		Department deptFound = null;
		for(Department depts: departments) {
			if(depts.getDeptName().equals(name)) {
				deptFound = depts;
				break;
			}
		}
		if(deptFound != null) {
			departments.remove(deptFound);
			System.out.println("Department Removed succesfully");
		}
	}

	void printDepartment(String name) {
		for(Department depts: departments) {
			if(depts.getDeptName().equals(name)) {
				depts.printDepartment();
				return;
			}
		}
		System.out.println("Department not found: " + name);
	}
}

class Department{
	private int ID,employeeCount;
	private String deptName,deptLocation;
	static private int currentDeptId = 10;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getEmployeeCount() {
		return employeeCount;
	}
	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptLocation() {
		return deptLocation;
	}
	public void setDeptLocation(String deptLocation) {
		this.deptLocation = deptLocation;
	}
	
	public Department(String deptName, String deptLocation) throws FieldEmptyException {
		super();
		ID = currentDeptId;
		currentDeptId += 10;
		this.employeeCount = 0;
		if(deptLocation.isEmpty() || deptName.isEmpty()) {
			throw new FieldEmptyException("Department Name and location must not be empty");
		}
		this.deptName = deptName;
		this.deptLocation = deptLocation;
	}
	
	public void printDepartment() {
		System.out.println("Department ID: " + ID);
		System.out.println("Department Name: " + deptName);
		System.out.println("Department Location: " + deptLocation);
		System.out.println("Department Employee Count: " + employeeCount);
	}
}