package javavariabletypes;

public class EnumTraining {

	private enum myFirstEnum {
		SMALL, MEDIUM, LARGE
	}
	
	myFirstEnum size;

	public myFirstEnum getSize() {
		return size;
	}

	public void setSize(myFirstEnum size) {
		this.size = size;
	}

	public static void main(String[] args) {
			EnumTraining et= new EnumTraining();
			et.setSize(myFirstEnum.SMALL);
			System.out.println(et.getSize());
			
			et.setSize(myFirstEnum.MEDIUM);
			System.out.println(et.getSize());
			
			et.setSize(myFirstEnum.LARGE);
			System.out.println(et.getSize());
	}

}
