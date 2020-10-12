package D3;

import java.util.Scanner;

public class D3_햄버거다이어트 {
	static int L;
	static int[] memo;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			L = sc.nextInt();
			memo = new int[L+1]; //제한칼로리까지의 맛 최대점수 저장
			
			int score = sc.nextInt();
			int cal = sc.nextInt();
			
			for(int i=cal; i<=L; i++) {
				memo[i] = score;
			}
			
			for(int i=1; i<N; i++) {
				score = sc.nextInt();
				cal = sc.nextInt();
				dp(score, cal);
			}
			
			System.out.println("#"+t + " " + memo[L]);
		}
	}
	
	static void dp(int s, int c) {
		for(int i=L; i>=c; i--) {
			if(memo[i] < memo[i-c]+s) {
				memo[i] = memo[i-c]+s;
			}
		}
	}
}
