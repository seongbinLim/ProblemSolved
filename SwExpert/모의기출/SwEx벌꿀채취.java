package 모의기출;
import java.util.Scanner;

public class SwEx벌꿀채취 {
	static class Point {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int[][] map;
	static int N;
	static int M;
	static int C;
	static Point start;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t=1; t<=tc; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			C = sc.nextInt();
			map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for(int i=0; i<=N-M; i++) {
				for(int j=0; j<N; j++) {
					start = new Point(i, j);
					nCr(i, j+M);
				}
			}
		}
	}
	
	static void nCr(int idxX, int idxY) {
		if(idxX>=N || idxY>=(N-M)) return;
		
		if(start.x == idxX) {
			
		} else {

			
		}
		
	}

}
