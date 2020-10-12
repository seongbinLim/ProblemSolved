package D3;

import java.util.Scanner;

public class SwEx5789 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		int tc = sc.nextInt();
		
		for(int test=1; test<=tc; test++) {
			int N = sc.nextInt();
			int Q = sc.nextInt();
			
			int[] num = new int[N+1];
			
			for(int i=1; i<=Q; i++) {
				int L = sc.nextInt();
				int R = sc.nextInt();
				
				for(int j=L; j<=R; j++) {
					num[j] = i;
				}
			}
			
			System.out.print("#"+test + " ");
			for(int i=1; i<N+1; i++) {
				System.out.print(num[i] + " ");
			}
			System.out.println();
		}
	}

}
