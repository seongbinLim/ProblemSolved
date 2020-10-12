package done;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BackJoon1261 {
	static int[][] map;
	static int[][] dp;
	static int col;
	static int row;
	static int min;
	static class Point {
		int x, y;
		int d;

		public Point(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		col = sc.nextInt();
		row = sc.nextInt();
		sc.nextLine();

		map = new int[row][col];
		dp = new int[row][col];

		for (int i = 0; i < row; i++) {
			String str = sc.next();
			for (int j = 0; j < col; j++) {
				map[i][j] = str.charAt(j) - '0';
				dp[i][j] = Integer.MAX_VALUE;
			}
		}

		dp[0][0] = 0;
		bfs();
		System.out.println(dp[row - 1][col - 1]);
	}

	static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0, 0));
		while (!q.isEmpty()) {
			Point cur = q.poll();
			//System.out.println(cur.x + ", " + cur.y + " : " + cur.d);

			int[] dx = { -1, 0, 1, 0 };
			int[] dy = { 0, 1, 0, -1 };

			for (int i = 0; i < 4; i++) {
				int newX = cur.x + dx[i];
				int newY = cur.y + dy[i];
				if (newX > -1 && newY > -1 && newX < row && newY < col) {
					if (map[newX][newY] == 0) {
						if (dp[newX][newY] > dp[cur.x][cur.y]) {
							dp[newX][newY] = dp[cur.x][cur.y];
							q.add(new Point(newX, newY, cur.d));
						} 
					}
					else if (map[newX][newY] == 1) {
						if (dp[newX][newY] > dp[cur.x][cur.y] + 1) {
							dp[newX][newY] = dp[cur.x][cur.y] + 1;
							q.add(new Point(newX, newY, cur.d + 1));
						}
					}
				}
			}
		}
	}

	static void backtrack(int x, int y, int count) {
		if (x == row - 1 && y == col - 1) {
			min = Math.min(min, count);
			return;
		}
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		for (int i = 0; i < 4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];

			if (newX > -1 && newY > -1 && newX < row && newY < col) {
				if (map[newX][newY] == 0 && count < min) {
					map[newX][newY] = -1;
					backtrack(newX, newY, count);
					map[newX][newY] = 0;
				}

				else if (map[newX][newY] == 1 && count < min) {
					map[newX][newY] = -1;
					backtrack(newX, newY, count + 1);
					map[newX][newY] = 1;
				}
			}
		}
	}
}
