package done;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BackJoon1238 {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int X = sc.nextInt()-1;
		
		int[][] time = new int[N][N];
		int[][] dp = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++)
				dp[i][j] = 1234567;
			
			dp[i][i] = 0;
		}
		
		for(int i=0; i<M; i++) {
			int S = sc.nextInt()-1;
			int E = sc.nextInt()-1;
			int T = sc.nextInt();
			
			time[S][E] = T;
			dp[S][E] = T;
		}
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i!=j) {
					for(int inter = 0; inter<N; inter++) {
						//if(i == inter)
						//	continue;
						if(dp[i][inter]==0 || dp[inter][j]==0)
							continue;
						if(dp[i][j] > dp[i][inter] + dp[inter][j]) {
							dp[i][j] = dp[i][inter] + dp[inter][j];
						}
					}
				}
			}
		}
		
		//for(int i=0; i<N; i++)
		//	System.out.println(Arrays.toString(dp[i]));
		
		int max = 0;
		for(int i=0; i<N; i++) {
			max = Math.max(max, dp[i][X] + dp[X][i]);
		}
		
		System.out.println(max);
	}

}
