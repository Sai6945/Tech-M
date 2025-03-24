package Day2and3;
class Payment{
	 void  pay(double amount) {
		System.out.println("pay using a default method " +amount);
		
	}
	 void  pay(double amount,String method) {
		System.out.println(+amount+","+method);
		
	}
	 void  pay(double amount,String method,int EMIMonths) {
		System.out.println(+amount+","+method+","+EMIMonths);
		
	}
}

public class PaymentSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Payment p=new Payment();
		p.pay(5000);
		p.pay(5000,"UPI");
		p.pay(6000,"CreditCard",8);

	}

}
