package impl;

import javavariabletypes.EmployeeInterface;

public class EmployeeData implements EmployeeInterface {

	public static void main(String[] args) {
		EmployeeData ed = new EmployeeData();
		ed.setEmployeeName("101", "Robin");
		System.out.println(ed.getEmployeeName("101"));
		System.out.println(ed.getEmployeeName("102"));
		ed.setEmployeeName("102", "SecondEmployee");
		System.out.println(ed.getEmployeeName("102"));

		System.out.println(ed instanceof EmployeeData);
		System.out.println(ed instanceof EmployeeInterface);
		System.out.println(ed.getEmployeeName("102") instanceof String);

		byte i = 127;
		System.out.println(++i - (--i));
		byte j = 127;
		System.out.println(++j);
		System.out.println(++j);
		short k = 10; // k = 0000 1010
		System.out.println(~k); // 1111 0101
		System.out.println(k << 2); // 0010 1000
		System.out.println(k >> 2); // 0000 0010
		short l = 127; // 0111 1111
		System.out.println(l >>> 1); // 0011 1111

//		Find max without using logical
		int a = 21, b = 2;
		int z = a - b;
		int ij = (z >> 31) & 0x1; // & operator to find max
		int max = a - ij * z;
		System.out.println(max);

//		Find min without using logical
		a = 21;
		b = 2;
		z = a - b;
		ij = (z >> 31) | 0x1; // | (OR) operator to find min
		int min = a - ij * z;
		System.out.println(min);
		
		System.out.println(2+3-1); // +,- same precedent whiever comes firts will be resolved
		System.out.println(2*4*2/4);
		
//		Enhanced FOR Loop
		
		int[] i1 = {10,20,30,40};
		
		for(int ifor : i1)
		{
			System.out.printf("%d, ",ifor);
		}
		
			

	}

	@Override
	public String getEmployeeName(String empId) {

		if (employeeData[0][0].equalsIgnoreCase(empId)) {
			return employeeData[0][1];
		}

		return "Employee Not Found!!";
	}

	@Override
	public void setEmployeeName(String empId, String empName) {

		employeeData[0][0] = empId;
		employeeData[0][1] = empName;

	}

}
