package D3;

import java.util.Scanner;

public class SwEx4299 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		int tc = sc.nextInt();
		
		for(int test=1; test<=tc; test++) {
			int day = sc.nextInt()-11;
			int hour = sc.nextInt()-11;
			int min = sc.nextInt()-11;
			
			int total = day*24*60 + hour * 60 + min;
			
			if(total < 0) {
				System.out.println("#"+test + " " + -1);
			} else {
				System.out.println("#"+test + " " + total);
			}
		}

	}

}
