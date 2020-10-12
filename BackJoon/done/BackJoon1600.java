package done;
import java.util.Scanner;

public class BackJoon1600 {
	static int N;
	static int M;
	static int possible;
	static int[][] map;
	static int[] dr = {-1,0,1,0,-2,-2,-1,1,2,2,1,-1};
	static int[] dc = {0,1,0,-1,-1,1,2,2,1,-1,-2,-2};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		possible = sc.nextInt();
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		move(0,0,0,-1);
	}
	
	static void move(int curX, int curY, int horseCount, int walk) {
		if(horseCount > possible)
			return;
		if(curX < 0 || curY < 0 || curX >= N || curY >= M)
			return;
		if(map[curX][curY]==1)
			return;
		if(curX==N-1 && curY==M-1) {
			System.out.println(walk);
			return;
		}
		walk++;
		for(int i=0; i<12; i++) {
			curX += dr[i];
			curY += dc[i];
			if(i > 3) {
				move(curX, curY, horseCount++, walk);
			} else {
				move(curX, curY, horseCount, walk);
			}
		}
	}

}
