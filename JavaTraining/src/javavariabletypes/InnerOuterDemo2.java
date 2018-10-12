package javavariabletypes;

import javavariabletypes.InnerOuterDemo.InnerClass;

// Below is error as inner class 2 is private
//import javavariabletypes.InnerOuterDemo.InnerClass2;

public class InnerOuterDemo2 {
	

	public static void main(String[] args) {
		InnerOuterDemo2 id2 = new InnerOuterDemo2();
		id2.innerClassObject();

	}
	
	public void innerClassObject() {
		InnerOuterDemo InnerOuterDemo = new InnerOuterDemo();
		InnerClass in = InnerOuterDemo.new InnerClass();
		in.finalize();
		
//		Below is error as Inner class2 can not be imported
//		InnerClass2 in2 = InnerOuterDemo.new InnerClass2();
//		in2.finalize();
		
//		Inner class2 can be access using the blow method only
		InnerOuterDemo.inner2ClassObject();
		System.out.println(in.getIntValue());
		System.out.println(in.getSampleIntValue());

	}

}
