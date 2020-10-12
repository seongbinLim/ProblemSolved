package done;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BackJoon2589 {
	static int[][] map;
	static int N;
	static int M;

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

		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				if (str.charAt(j) == 'W')
					map[i][j] = -1;
				else {
					map[i][j] = 0;
				}
			}
		}

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					Queue<Point> q = new LinkedList<>();
					q.add(new Point(i, j));
					boolean[][] v = new boolean[N][M];
					v[i][j] = true;
					int time = 0;
					while (!q.isEmpty()) {
						time++;
						int size = q.size();
						for (int turn = 0; turn < size; turn++) {
							Point p = q.poll();
							int[] dx = { -1, 0, 1, 0 };
							int[] dy = { 0, 1, 0, -1 };

							for (int k = 0; k < 4; k++) {
								int newX = p.x + dx[k];
								int newY = p.y + dy[k];

								if (newX > -1 && newY > -1 && newX < N && newY < M && !v[newX][newY]
										&& map[newX][newY] != -1) {
									q.add(new Point(newX, newY));
									v[newX][newY] = true;
								}
							}
						}
					}

					max = Math.max(max, time);
				}
			}
		}

		System.out.println(max-1);

	}
}
