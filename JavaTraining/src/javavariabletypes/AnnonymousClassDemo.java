package javavariabletypes;

public class AnnonymousClassDemo {

	public static void main(String[] args) {
		SampleAbstractClass sample = new SampleAbstractClass() {
			public void printAbstractMethod() {
				System.out.println("Inside Abstract Method overriden body");
			}
		};
		
		sample.printAbstractMethod();

	}

}

abstract class SampleAbstractClass{
	public abstract void printAbstractMethod();
}
