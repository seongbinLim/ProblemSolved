package done;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BackJoon2636 {
	static int N, M;
	static int[][] arr, copy;

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		copy = new int[N][M];

		Queue<Point> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
				copy[i][j] = arr[i][j];
				if (arr[i][j] == 1)
					q.add(new Point(i, j));
			}
		}
		outair(0, 0);
		for (int i = 0; i < N; i++) {
			copy[i] = arr[i].clone();
		}
		int cheeseCnt = 0;
		int time = 0;
		while (!q.isEmpty()) {
			cheeseCnt = q.size();
			time++;
			for (int k = 0; k < cheeseCnt; k++) {
				Point p = q.poll();
				if (isEdge(p.x, p.y)) {
					copy[p.x][p.y] = -1;
				} else {
					q.add(p);
				}
			}
			for (int i = 0; i < N; i++) {
				arr[i] = copy[i].clone();
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == -1) {
						Queue<Point> removeQ = new LinkedList<>();
						removeQ.add(new Point(i, j));
						while (!removeQ.isEmpty()) {
							Point np = removeQ.poll();
							for (int dir = 0; dir < 4; dir++) {
								int nx = np.x + dx[dir];
								int ny = np.y + dy[dir];
								if (nx > -1 && ny > -1 && nx < N && ny < M && arr[nx][ny] == 0) {
									arr[nx][ny] = -1;
									removeQ.add(new Point(nx,ny));
								}
								
							}
						}
					}
				}
			}
		}

		System.out.println(time + "\n" + cheeseCnt);

	}

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static boolean isEdge(int x, int y) {
		for (int i = 0; i < 4; i++)
			if (arr[x + dx[i]][y + dy[i]] == -1)
				return true;
		return false;
	}

	static void outair(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < M) {
			if (arr[x][y] == 0) {
				arr[x][y] = -1;
				for (int dir = 0; dir < 4; dir++) {
					int nx = x + dx[dir];
					int ny = y + dy[dir];
					outair(nx, ny);
				}
			}
		}
	}
}
