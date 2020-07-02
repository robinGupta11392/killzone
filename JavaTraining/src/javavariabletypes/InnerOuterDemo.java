package javavariabletypes;

public class InnerOuterDemo {
	
	private int num =25;
	int sampleNum = 10;

	static {
		System.out.println("Inside Outer Class's static block");
	}

	protected void finalize() {
		System.out.println("Inside Outer Class's finalize block");
	}

	public InnerOuterDemo() {
		System.out.println("Inside Outer Class's constructor now");
	}

	class InnerClass {
		
		public int getIntValue() {
			return num;
		}
		
		public int getSampleIntValue() {
			return sampleNum;
		}
		
		protected void finalize() {
			System.out.println("Inside Inner Class's finalize block");
		}
		public InnerClass() {
			System.out.println("Inside Inner Class now");
		}
	}
	
	private class InnerClass2 {
		protected void finalize() {
			System.out.println("Inside Inner2 Class's finalize block");
		}
		public InnerClass2() {
			System.out.println("Inside Inner2 Class now");
		}
	}

	public static void main(String[] args) {
		InnerOuterDemo i = new InnerOuterDemo();
		i.finalize();
		i.innerClassObject();
		 

	}
	
	public void innerClassObject() {
		InnerClass in = new InnerClass();
		in.finalize();
	}
	
	public void inner2ClassObject() {
		InnerClass2 in = new InnerClass2();
		in.finalize();
	}

}
