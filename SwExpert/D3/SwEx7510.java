package D3;

import java.util.Scanner;

public class SwEx7510 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int test=1; test<=tc; test++) {
			int number = sc.nextInt();
			
			int count = 1;
			
			for(int i=2; i<=number; i++) {
				if(i%2 == 1 && number%i == 0 && ((number/i-1)*2)+1>=i) {
					count++;
				}
				double a = i/2;
				if(i%2 == 0 && number%i == a && (number/i*2)>= i) {
					count++; 
				}
			}
			System.out.println("#"+test+" "+count);
			 
		}

	}

}
