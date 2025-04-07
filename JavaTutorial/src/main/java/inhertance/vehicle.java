package inhertance;

public class vehicle extends Car  {

	int i = 10000;
	
	void vehicleqw() {
		System.out.println("all vehicle's");
	}
	
	public static void main(String[] args) {
		
		vehicle ve = new vehicle();
		
		System.out.println(ve.i);
		System.out.println(ve.Apaiche());
		System.out.println("");
		System.out.println(ve.bnw());
		ve.jackwar();	
		
		
		
	}
}
