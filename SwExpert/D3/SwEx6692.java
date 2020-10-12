package D3;

import java.util.Scanner;

public class SwEx6692 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		int tc = sc.nextInt();
		
		for(int test=1; test<=tc; test++) {
			int T = sc.nextInt();
			double total = 0.0;
			for(int i=0; i<T; i++) {
				double percent = sc.nextDouble();
				int money = sc.nextInt();
				
				total += percent*money;
			}
			System.out.println("#" + test + " " + total);
		}
	}

}
