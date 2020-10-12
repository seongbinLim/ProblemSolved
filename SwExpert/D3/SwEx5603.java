package D3;

import java.util.Scanner;

public class SwEx5603 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		int tc = sc.nextInt();
		
		for(int test=1; test<=tc; test++) {
			int N = sc.nextInt();
			int[] guncho = new int[N];
			
			int total = 0;
			for(int i=0; i<N; i++) {
				guncho[i] = sc.nextInt();
				total+=guncho[i];
			}
			
			int avg = total/N;
			int count = 0;
			for(int i=0; i<N; i++) {
				if(avg < guncho[i]) {
					count += guncho[i] - avg;
				}
			}
			
			System.out.println("#" + test + " " + count);
		}
	}

}
