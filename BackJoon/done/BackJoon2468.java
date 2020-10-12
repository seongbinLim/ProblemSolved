package done;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BackJoon2468 {
	static int[][] map;
	static int areaMax;
	static class Pos {
		int x;
		int y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int max = 0;
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				max = Math.max(max, map[i][j]);
			}
		}
		
		areaMax = 0;
		for (int rain = 0; rain <= max; rain++) {
			boolean[][] v = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (rain >= map[i][j]) {
						v[i][j] = true;
					}
				}
			}
			areaMax = Math.max(areaMax, dfs(v));
		}
		
		System.out.println(areaMax);
	}

	static int dfs(boolean[][] v) {
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		int count = 0;
		Queue<Pos> q = new LinkedList<>();		
		
		for (int i = 0; i < v.length; i++) {
			for (int j = 0; j < v[i].length; j++) {
				if(!v[i][j]) {
					v[i][j] = true;
					q.add(new Pos(i, j));
					while(!q.isEmpty()) {
						Pos p = q.poll();
						for(int k=0; k<4; k++) {
							int newX = p.x+dx[k];
							int newY = p.y+dy[k];
							if(newX > -1 && newY > -1 && newX < v.length && newY < v.length && !v[newX][newY]) {
								v[newX][newY] = true;
								q.add(new Pos(newX, newY));
							}
						}
					}
					count++;
				}
			}
		}
		return count;
	}

}
