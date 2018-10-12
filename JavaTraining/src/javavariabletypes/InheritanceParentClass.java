package javavariabletypes;

public class InheritanceParentClass {
	
	public InheritanceParentClass() {
		System.out.println("Parent's Contructor");
	}
	
	public InheritanceParentClass( String name) {
		System.out.println("Parent's parameterized Contructor" + name);
	}

	public static void main(String[] args) {
		InheritanceParentClass ip = new InheritanceParentClass();
	}
	
	public void demoMethod() {
		System.out.println("Parent Public demo");
	}
	protected void demoMethod1() {
		System.out.println("Parent Protected demo");
	}
	private void demoMethod2() {
		System.out.println("Parent Private demo");
	}
	static void demoMethod3() {
		System.out.println("Parent Static demo");
	}
	
	protected void overrideDemo() 
	{
		System.out.println("Parent Method");
	}
	
	public void NonoverrideDemoFromParent() 
	{
		System.out.println("Parent's non Method");
	}

}
