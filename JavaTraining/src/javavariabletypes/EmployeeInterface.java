package javavariabletypes;

public interface EmployeeInterface {
	
	public String[][] employeeData = new String[1][2];
	
	public String getEmployeeName(String empId);
	public void setEmployeeName(String empId, String empName);

}
