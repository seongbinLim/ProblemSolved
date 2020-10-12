package D3;

import java.util.Arrays;
import java.util.Scanner;

public class D3_오셀로게임 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] dx = {-1,-1,0,1,1,1,0,-1};
		int[] dy = {0,1,1,1,0,-1,-1,-1};
		
		int tc = sc.nextInt();
		
		for(int test=1; test<=tc; test++) {
			int N = sc.nextInt()+1;
			int[][] map = new int[N][N];
			
			int mid = N/2;
			map[mid][mid] = 2;
			map[mid+1][mid+1] = 2;
			map[mid+1][mid] = 1;
			map[mid][mid+1] = 1;

			
			int turn = sc.nextInt();
			
			for(int i=0; i<turn; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				int dol = sc.nextInt();
				
				map[x][y] = dol;
				for(int k=0; k<8; k++) {
					int newX = x+dx[k];
					int newY = y+dy[k];
					while( newX > 0 && newY > 0 && newX < N && newY < N && map[newX][newY] == (dol%2+1)) {
						newX = newX + dx[k];
						newY = newY + dy[k];
					}
					
					if(newX > 0 && newY > 0 && newX < N && newY < N && map[newX][newY] == dol) {
						do {
							newX = newX - dx[k];
							newY = newY - dy[k];
							map[newX][newY] = dol;
						} while(!(newX == x && newY == y));
					}
				}
				
			}
			
			int white = 0;
			int black = 0;
			
			for(int i=1; i<N; i++) {
				for(int j=1; j<N; j++) {
					if(map[i][j] == 1) {
						black++;
					} else if(map[i][j] == 2) {
						white++;
					}
					
				}				
			}
			
			System.out.println("#"+test+" " + black + " " + white);
			
		}

	}

}
