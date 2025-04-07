package Javatuto;

public class AxisABank implements BankInterface {  // Renamed for clarity
    
   public void loan() {
	   System.out.println("Loan");
   }

   
	@Override
	public void Addharmedantory() {
		System.out.println("Addhar");		
	}

	@Override
	public boolean Pancard() {
		// TODO Auto-generated method stub
		return true;
	}
	public static void main(String[] args) {
		AxisABank mybank = new AxisABank();
		mybank.Addharmedantory();
		boolean bnann = mybank.Pancard();
		System.out.println(bnann);
		mybank.loan();
		System.out.println(mybank.Uplimit);
		
	}
}
