package D4;

import java.util.Arrays;
import java.util.Scanner;

public class D4_재관이의대량할인 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int[] num = new int[N];
			
			int total = 0;
			for(int i=0; i<N; i++) {
				num[i] = sc.nextInt();
				total += num[i];
			}
			
			Arrays.sort(num);
			int start = -1;
			if(N%3==0) {
				start = 0;
			} else if(N%3==1) {
				start = 1;
			} else {
				start = 2;
			}
			
			int free = 0;
			for(int i=start; i<N; i=i+3) {
				free += num[i];
			}
			
			System.out.println("#"+t+" "+(total-free));
		}

	}

}
