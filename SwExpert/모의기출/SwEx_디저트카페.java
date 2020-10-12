package 모의기출;
import java.util.Scanner;

public class SwEx_디저트카페 {

	static int sx, sy;
	static int N, max;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int t = 1; t <= tc; t++) {
			N = sc.nextInt();
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			max = -1;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					boolean[] num = new boolean[101];
					sx = i;
					sy = j;
					num[map[i][j]] = true;
					dfs(0, i,j,0,1, num);
					
				}
			}
			
			System.out.println("#"+t+" " + max);
		}
	}
	
	static void dfs(int len, int x, int y, int dir, int count, boolean[] num) {
		
		int[] dx = { 1, 1, -1, -1 };
		int[] dy = { 1, -1, -1, 1 };
		
		for(int i=0; i<2; i++) {
			int newD = (dir + i)%4;
			int newX = x + dx[newD];
			int newY = y + dy[newD];
			if(i==1) len++;
			if(len==4) return;
			
			if(newX==sx && newY==sy) {
				max = Math.max(max, count);
			}
			if(newX>-1&&newY>-1&&newX<N&&newY<N&&!num[map[newX][newY]]) {
				num[map[newX][newY]] = true;
				//System.out.println(newX + "," + newY);
				dfs(len, newX, newY, newD, count+1, num);
				//System.out.println("___________fin");
				num[map[newX][newY]] = false;
			}
		}
		
		
	}

}
