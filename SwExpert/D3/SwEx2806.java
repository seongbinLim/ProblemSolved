package D3;

import java.util.Arrays;
import java.util.Scanner;

public class SwEx2806 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		int tc = sc.nextInt();
		
		for(int test=1; test<=tc; test++) {
			int N = sc.nextInt();
			int possible = 0;
			boolean[][] visited = new boolean[N][N];
			int[] dx = {0,-1,-1,1,1,-1,0,0,1};
			int[] dy = {0,-1,1,-1,1,0,1,-1,0};
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int[][] map = new int[N][N];
					int count = 0;
					for(int c=0; c<N; c++) {
						for(int m=i; m<N; m++) {
							for(int n=j; n<N; n++) {
								if(map[m][n] == 0 && !visited[m][n]) {
									int x = m, y = n;
									//visited[m][n] = true;
					 				count++;
									for(int k=0; k<9; k++) {
										for(int l=0;l<N;l++) {
											x += dx[k];
											y += dy[k];
											if(x>-1 && y>-1 && x<N && y<N)
												map[x][y] = -1;
										}
									}
								}
							}
						}
					}
					if(count == N) {
						possible++;
					for(int m=i; m<N; m++) {
						for(int n=j; n<N; n++) {
							if(map[m][n] == 0)
								possible++;
						}
					}
					}
				}
			}
			System.out.println("#"+test+" " + possible);
		}
	}
}
