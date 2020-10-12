package done;

import java.util.Arrays;
import java.util.Scanner;

public class BackJoon2579 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] score = new int[N+1];
		int[] dp = new int[N+1];
		for(int i=1; i<N+1; i++) {
			score[i] = sc.nextInt();
		}
		dp[0] = 0;
		if(N>0) dp[1] = score[1];
		if(N>1) dp[2] = Math.max(score[1]+score[2], score[2]);
		if(N>2) dp[3] = Math.max(score[1]+score[3], score[2]+score[3]);
		for(int i=4; i<N+1; i++) {
			dp[i] = Math.max(dp[i-3]+score[i-1]+score[i], dp[i-2]+score[i]);
		}
		//System.out.println(Arrays.toString(dp));
		System.out.println(dp[N]);
	}
}
