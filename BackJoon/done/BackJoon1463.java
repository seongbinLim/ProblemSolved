package done;

import java.util.Arrays;
import java.util.Scanner;

public class BackJoon1463 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] memo = new int[N+1];
		memo[1] = 0;
		if(N > 1) memo[2] = 1;
		if(N > 2) memo[3] = 1;
		for(int i=4; i<=N; i++) {
			int num = i;
			int min = Integer.MAX_VALUE;
			
			if(num%3==0) {
				min = Math.min(min, memo[num/3]);
			} 
			if(num%2==0) {
				min = Math.min(min, memo[num/2]);
			}
			min = Math.min(min, memo[num-1]);
			
			memo[i] = min+1;	
		}
		System.out.println(memo[N]);
		//System.out.println(Arrays.toString(memo));

	}

}
