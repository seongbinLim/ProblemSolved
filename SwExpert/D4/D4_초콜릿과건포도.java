package D4;
import java.util.Arrays;
import java.util.Scanner;
//★복습필요★
public class D4_초콜릿과건포도 {
	static int[][] map;
	static int[][][][] dp; //r,c,w,h
	static int N;
	static int M;
	static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t=1; t<=tc; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			map = new int[N][M];
			dp = new int[N+1][M+1][N+1][M+1];
			for(int[][][] d1 : dp) {
				for(int[][] d2 : d1) {
					for(int[] d3 : d2) {
						Arrays.fill(d3, Integer.MAX_VALUE);
					}
				}
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			result = backtrack(0,0,N, M);
			System.out.println("#"+t+" " + result);
		}
	}

	static int backtrack(int r, int c, int h, int w) {
		if(w==1 && h ==1) return 0;
		
		if(dp[r][c][h][w] != Integer.MAX_VALUE ) {
			return dp[r][c][h][w];
		}
		
		int sum = 0;
		for(int i=r; i<r+h; i++) {
			for(int j=c; j<c+w; j++) {
				sum += map[i][j];
			}
		}
		
		for(int i=1; i<h; i++) {
			dp[r][c][i][w] = backtrack(r, c, i, w);
			dp[r+i][c][h-i][w] = backtrack(r+i, c, h-i, w);

			dp[r][c][h][w] = Math.min(dp[r][c][h][w], sum+dp[r][c][i][w]+dp[r+i][c][h-i][w]);
		}
		
		for(int i=1; i<w; i++) {
			dp[r][c][h][i] = backtrack(r, c, h, i);
			dp[r][c+i][h][w-i] = backtrack(r, c+i, h, w-i);
			
			dp[r][c][h][w] = Math.min(dp[r][c][h][w], sum+dp[r][c][h][i]+dp[r][c+i][h][w-i]);
		}
		
		return dp[r][c][h][w];
	}

}
