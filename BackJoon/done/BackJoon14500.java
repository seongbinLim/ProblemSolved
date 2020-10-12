package done;

import java.util.Scanner;

public class BackJoon14500 {

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
		int max = 0;
		int[][][] ternomino = {{{1,0},{2,0},{3,0}}, {{0,1},{0,2},{0,3}} ,{{1,0},{0,1},{1,1}}, 
							{{1,0},{2,0},{2,1}}, {{1,0},{0,1},{0,2}}, {{0,1},{1,1},{2,1}}, {{0,1},{0,2},{-1,2}},
							{{0,1},{-1,1},{-2,1}}, {{0,1},{0,2},{1,2}}, {{0,1},{1,0},{2,0}}, {{1,0},{1,1},{1,2}},
							{{1,0},{1,1},{2,1}}, {{0,1},{-1,1},{-1,2}}, {{0,1},{-1,1},{1,0}},{{0,1},{1,1},{1,2}},
							{{1,0},{2,0},{1,1}}, {{0,1},{0,2},{1,1}}, {{0,1},{-1,1},{0,2}}, {{0,1},{-1,1},{1,1}}};
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {				
				for(int k=0; k<19; k++) {
					int sum = map[i][j];
					boolean isFit = true;
					
					B : for(int m=0; m<3; m++) {
						int ni = i + ternomino[k][m][0];
						int nj = j + ternomino[k][m][1];
						
						if(ni<0 || nj<0 || ni>=N || nj>=M) {
							isFit = false;
							break B;
						}
						
						sum += map[ni][nj];
					}
					
					if(isFit)
						max = Math.max(max, sum);
						
				}
			}
		}
		
		System.out.println(max);
	}

}
