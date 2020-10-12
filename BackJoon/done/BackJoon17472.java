package done;

import java.util.ArrayList;
import java.util.Scanner;

public class BackJoon17472 {
	static class Island {
		int sx,sy,ex,ey;
		public Island(int sx, int sy, int ex, int ey) {
			this.sx = sx;
			this.sy = sy;
			this.ex = ex;
			this.ey = ey;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] map = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		boolean[][] v = new boolean[N][M];
		ArrayList<Island> islands = new ArrayList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				int r = i;
				int c = j;
				if(!v[r][c] && map[r][c] == 1) {
					int er = r;
					int ec = c;
					for(int k=r; k<N; k++) {
						if(v[k][c] || map[k][c]==0)
							break;
						v[k][c] = true;
						er++;
					}
					for(int k=c; k<M; k++) {
						if(v[r][k] || map[r][k]==0)
							break;
						v[r][k] = true;
						ec++;
					}
					islands.add(new Island(r,c,er,ec));
				}
			}
		}
		
		
		
	}
	
	//1. 각 점까지의 제일 짧은 거리 저장
	//2. 프림 vs 크루스칼 알고리즘 사용하여 다리짓기

}
