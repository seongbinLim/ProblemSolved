package D3;

import java.util.Scanner;

public class D3_professional조합 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			long N = sc.nextLong();
			long R = sc.nextLong();
			
			long result = factorial(N)%1234567891 * pow(factorial(R), 1234567891-2)%1234567891 * pow(factorial(N-R), 1234567891-2)%1234567891; 
			

			System.out.println("#"+t+" " + result);
		}

	}
	
	static long pow(long a, long b) {
		if(b==1) return a;
		if(b==0) return 1;
		if(b%2==0) {
			long newA = pow(a, b/2);
			return newA*newA%1234567891;
		}
		
		//홀수인 경우
		long newA = pow(a, (b-1)/2);
		return newA*newA%1234567891*a%1234567891;
		
	}
	
	static long factorial(long a) {
		long result = 1;
		for(int i=2; i<=a; i++) {
			result = result*i%1234567891;
			//result = result*i;
		}
		//System.out.println("fact" + a + " : " + result);
		return result;
	}

}
