package done;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BackJoon16234 {
	static class Point {
		int x, y;
		int value;

		public Point(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int L = sc.nextInt();
		int R = sc.nextInt();

		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int moveCnt = 0;

		while (true) {
			boolean fin = true;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i - 1 >= 0 && Math.abs(map[i - 1][j] - map[i][j]) >= L
							&& Math.abs(map[i - 1][j] - map[i][j]) <= R) {
						fin = false;
					}

					if (j - 1 >= 0 && Math.abs(map[i][j - 1] - map[i][j]) >= L
							&& Math.abs(map[i][j - 1] - map[i][j]) <= R) {
						fin = false;
					}
				}
			}
			if (fin)
				break;

			boolean[][] v = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!v[i][j]) {
						int total = 0;
						ArrayList<Point> save = new ArrayList<>();
						save.add(new Point(i, j, map[i][j]));
						Queue<Point> q = new LinkedList<>();
						q.add(new Point(i, j, map[i][j]));
						total += map[i][j];
						v[i][j] = true;
						while (!q.isEmpty()) {
							int[] dx = {-1, 0, 1, 0};
							int[] dy = {0, 1, 0, -1};

							Point p = q.poll();
							for (int k = 0; k < 4; k++) {
								int nx = p.x + dx[k];
								int ny = p.y + dy[k];
								if (nx > -1 && ny > -1 && nx < N && ny < N && !v[nx][ny]) {
									if (Math.abs(map[p.x][p.y] - map[nx][ny]) >= L
											&& Math.abs(map[p.x][p.y] - map[nx][ny]) <= R) {
										q.add(new Point(nx, ny, map[nx][ny]));
										save.add(new Point(nx, ny, map[nx][ny]));
										v[nx][ny] = true;
										total += map[nx][ny];
									}
								}
							}
						}

						int data = (int) Math.floor(total / save.size());
						for (Point p : save) {
							map[p.x][p.y] = data;
						}

					}
				}
			}
			moveCnt++;
		}

		System.out.println(moveCnt);
	}

}
