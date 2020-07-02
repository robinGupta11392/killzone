/**
 * Conclusion: Whichever object we create the overridden method will be taken from there
 * Conlusion2: Whichever Reference we take for the variable the methods will be visible according to it.
 * Parent Reference will have only parent's method as visible no matter you create Parent object or child
 * Child Reference will have both parent and child methods and properties access except private members of parent class
 */

package javavariabletypes;

public class InheritanceChildClass extends InheritanceParentClass {
	
	public void demoMethodChild() {
		System.out.println("Child Public demo");
	}
	protected void demoMethod1Child() {
		System.out.println("Child Protected demo");
	}
	private void demoMethod2Child() {
		System.out.println("Child Private demo");
	}
	static void demoMethod3Child() {
		System.out.println("Child Static demo");
	}
	
	protected void overrideDemo() 
	{
		System.out.println("Child Method");
	}
	
	public void NonoverrideDemo() 
	{
		System.out.println("Child's non Method");
	}
	
	public InheritanceChildClass() {
		System.out.println("Child's Constructor");
	}
	
	public InheritanceChildClass(String name) {
		super(name);
		System.out.println("Child's Constructor");
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		InheritanceChildClass ic2 = new InheritanceChildClass("Robins");
		InheritanceChildClass ic = new InheritanceChildClass();
		ic.demoMethod();
		ic.demoMethod1();
//		ic.demoMethod2(); <== This is private of Parent not visible
		ic.demoMethod3();
		ic.NonoverrideDemoFromParent();
		ic.overrideDemo();
		ic.demoMethodChild();
		ic.demoMethod1Child();
		ic.demoMethod2Child();
		ic.demoMethod3Child();
		ic.NonoverrideDemo();
		System.out.println();
		
		InheritanceParentClass ipc = new InheritanceChildClass();
		ipc.demoMethod();
		ipc.demoMethod1();
//		ipc.demoMethod2(); <== Private method of Parent
		ipc.demoMethod3();
		ipc.NonoverrideDemoFromParent();
		ipc.overrideDemo();
//		ipc.demoMethodChild(); <== Child Methods are not visible as parent class reference is used
//		ipc.demoMethod1Child();
//		ipc.demoMethod2Child();
//		ipc.demoMethod3Child();
//		ipc.NonoverrideDemo();
		System.out.println();
		
		InheritanceParentClass ipcc = new InheritanceParentClass();
		ipcc.demoMethod();
		ipcc.demoMethod1();
//		ipcc.demoMethod2(); <== Parent's private Method
		ipcc.demoMethod3();
		ipcc.NonoverrideDemoFromParent();
		ipcc.overrideDemo();
//		ipcc.demoMethodChild(); <== Child is not in picture
//		ipcc.demoMethod1Child();
//		ipcc.demoMethod2Child();
//		ipcc.demoMethod3Child();
//		ipcc.NonoverrideDemo();
		
		InheritanceChildClass icp = (InheritanceChildClass) new InheritanceParentClass();
		icp.demoMethod();
		icp.demoMethod1();
//		icp.demoMethod2(); <== Parent's private method
		icp.demoMethod3();
		icp.NonoverrideDemoFromParent();
		icp.overrideDemo();
		icp.demoMethodChild();
		icp.demoMethod1Child();
		icp.demoMethod2Child();
		icp.demoMethod3Child();
		icp.NonoverrideDemo();

	}

}
