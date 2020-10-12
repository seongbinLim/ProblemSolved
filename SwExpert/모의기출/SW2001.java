package 모의기출;
import java.util.Scanner;

public class SW2001 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int test=1; test<=tc; test++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int max = 0;
			for(int i=0; i<=N-M; i++) {
				for(int j=0; j<=N-M; j++) {
					int sum = 0;
					for(int m=0; m<M; m++) {
						for(int n=0; n<M; n++) {
							sum += map[i+m][j+n];
						}
					}
					
					max = Math.max(max, sum);
				}
			}
			
			System.out.println("#" + test + " " + max);			
		}

	}

}
