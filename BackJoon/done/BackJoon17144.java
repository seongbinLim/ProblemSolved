package done;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BackJoon17144 {
	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int R = sc.nextInt();
		int C = sc.nextInt();
		int T = sc.nextInt();

		Queue<Point> q = new LinkedList<>();
		int[][] map = new int[R][C];
		int air1 = -1;
		int air2 = -1;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == -1) {
					if (air1 == -1)
						air1 = i;
					else
						air2 = i;
				} else if (map[i][j] != 0) {
					q.add(new Point(i, j));
				}
			}
		}
		
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		int spread = 0;
		while (!q.isEmpty() || T > 0) {
			spread = q.size();
			int[][] newMap = new int[R][C];
			for (int k = 0; k < spread; k++) {
				Point p = q.poll();
				int airSize = 0;
				for (int i = 0; i < 4; i++) {
					int newX = p.x + dx[i];
					int newY = p.y + dy[i];
					if (newX > -1 && newY > -1 && newX < R && newY < C 
					&& !(newY==0 && (newX == air1 || newX == air2))) {
						int air = map[p.x][p.y] / 5;
						newMap[newX][newY] += air;
						airSize += air;
					}
				}
				newMap[p.x][p.y] += map[p.x][p.y] - airSize;
			}
			
			newMap[air1][0] = -1;
			newMap[air2][0] = -1;
			for (int i = 0; i < R; i++) {
				map[i] = newMap[i].clone();
				//System.out.println(Arrays.toString(newMap[i]));
			}
			//System.out.println("-------------");
			
			for (int i = air1 - 2; i >= 0; i--) {
				map[i + 1][0] = map[i][0];
			}
			for (int j = 1; j < C; j++) {
				map[0][j - 1] = map[0][j];
			}
			for (int i = 1; i <= air1; i++) {
				map[i - 1][C-1] = map[i][C-1];
			}
			for (int j = C - 2; j >= 1; j--) {
				map[air1][j + 1] = map[air1][j];
			}
			map[air1][1] = 0;
			
			for (int i = air2+2; i < R; i++) {
				map[i - 1][0] = map[i][0];
			}
			for (int j = 1; j < C; j++) {
				map[R - 1][j - 1] = map[R - 1][j];
			}
			for (int i = R-2; i >= air2; i--) {
				map[i + 1][C-1] = map[i][C-1];
			}
			for (int j = C - 2; j >= 1; j--) {
				map[air2][j + 1] = map[air2][j];
			}
			map[air2][1] = 0;
			for (int i = 0; i < R; i++) {
				for(int j=0; j < C; j++) {
					if(map[i][j] > 0) q.add(new Point(i, j));
				}
				//System.out.println(Arrays.toString(map[i]));
			}
			//System.out.println("-------------");
			T--;
			if(T == 0) break;
		}

		int totalCount = 2;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				totalCount += map[i][j];
			}
			//System.out.println(Arrays.toString(map[i]));
		}
		System.out.println(totalCount);

	}

}
