package Javatuto;

public interface BankInterface {

	int Uplimit = 1000;
	default void bikeloan() {
		System.out.println("bike loan");
	}
	static void crloan() {
		System.out.println("car loan");
	}
	void Addharmedantory();
	boolean Pancard();
}
