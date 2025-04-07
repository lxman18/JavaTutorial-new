package Javatuto;

public class Javatutorial {
	
	public void java() {
		this.Num=1000;
	}
	public void phrra(int x) {
		this.x=x;
	}
	
	
	int x;
	int Num ;
	void bike() {
		this.Num = 10001;
		System.out.println(Num);
	}
	
	String car(){
		return "Alxmn";
	}
	int vehicle() {
		return 233;
	}
	
	
	
	public static void main(String[] args) {
		
		Javatutorial java = new Javatutorial();
		
		String c = java.car();
		System.out.println(c);
		
		java.bike();
		int i = java.vehicle();
		System.out.println(i);
		java.java();
		java.phrra(123);

	}

}
