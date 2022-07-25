
public class FunctionOverloadingTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Payment paymentObj = new Payment();
		
		paymentObj.pay();
		paymentObj.pay("Phone Pe",75);
		paymentObj.pay("Google Pay",84.25f);
		paymentObj.pay(45);
		paymentObj.pay(68.72f);
		paymentObj.pay(628475869427L,65);
		paymentObj.pay(628475869427L,152.86f);
	}
}


class Payment{
	//cash
	void pay() {
		System.out.println("Pay with cash with default charge of Rs.100");
	}
	//UPI option, int version
	void pay(String option,int amount) {
		System.out.println("Pay with "  + option + " with charge of Rs. " + amount);
	}
	//UPI option, float version
	void pay(String option,float amount) {
		System.out.println("Pay with "  + option + " with charge of Rs. " + amount);
	}
	//custom cash option, int version
	void pay(int amount) {
		System.out.println("Pay with cash with custom charge of Rs. " + amount);
	}
	//custom cash option, float version
	void pay(float amount) {
		System.out.println("Pay with cash with custom charge of Rs. " + amount);
	}
	//credit or debit pay option, int version
	void pay(long cardNumber,int amount) {
		System.out.println("Pay with "  + cardNumber + " card with charge of Rs. " + amount);
	}
	//credit or debit pay option, float version
	void pay(long cardNumber,float amount) {
		System.out.println("Pay with "  + cardNumber + " card with charge of Rs. " + amount);
	}
}