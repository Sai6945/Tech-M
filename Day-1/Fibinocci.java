package Day1;
import java.util.*;
public class Fibinocci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc=new Scanner(System.in);
System.out.println("Enter a number");
int n=sc.nextInt();
int count=0;
int first=0,second=1;
do {
	System.out.print(first);
	count++;
	if(count<n) {
		System.out.print(" , ");
	}
	int temp=first+second;
	first=second;
	second=temp;
}while(count<n);
	}

}
