package done;

import java.util.ArrayList;
import java.util.Scanner;

public class BackJoon15683 {
	static int N, M;
	static int min;
	static int[][] map;
	static boolean[][] v;
	static ArrayList<Point> cctvs = new ArrayList<>();

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
		map = new int[N][M];
		v = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] != 0 && map[i][j] != 6) {
					cctvs.add(new Point(i, j));
				}
			}
		}
		min = Integer.MAX_VALUE;
		dfs(0);
		System.out.println(min);
	}

	static void dfs(int total) {
		//System.out.println(total);
		if (total == cctvs.size()) {
			//print();
			//System.out.println("--------------------------------");
			int none = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0)
						none++;
				}
			}

			min = Math.min(min, none);
			return;
		}

		int[][] copy = new int[N][M];
		for(int i=0; i<N; i++)
			copy[i] = map[i].clone();
		
		Point p = cctvs.get(total);
		for (int k = 0; k < 4; k++) {
			change(p.x, p.y, k);
			dfs(total + 1);
			for(int i=0; i<N; i++)
				map[i] = copy[i].clone();
		}
	}

	static void change(int i, int j, int dir) {
		if (map[i][j] == 1) {
			if (dir == 0) {
				up(i, j);
			} else if (dir == 1) {
				right(i, j);
			} else if (dir == 2) {
				down(i, j);
			} else {
				left(i, j);
			}
		} else if (map[i][j] == 2) {
			if (dir == 0 || dir == 2) {
				up(i, j);
				down(i, j);
			} else if (dir == 1 || dir == 3) {
				left(i, j);
				right(i, j);
			}
		} else if (map[i][j] == 3) {
			if (dir == 0) {
				up(i, j);
				right(i, j);
			} else if (dir == 1) {
				right(i, j);
				down(i, j);
			} else if (dir == 2) {
				down(i, j);
				left(i, j);
			} else {
				left(i, j);
				up(i, j);
			}
		} else if (map[i][j] == 4) {
			if (dir == 0) {
				up(i, j);
				right(i, j);
				down(i, j);
			} else if (dir == 1) {
				right(i, j);
				down(i, j);
				left(i, j);
			} else if (dir == 2) {
				down(i, j);
				left(i, j);
				up(i, j);
			} else {
				left(i, j);
				up(i, j);
				right(i, j);
			}
		} else if (map[i][j] == 5) {
			up(i, j);
			right(i, j);
			down(i, j);
			left(i, j);
		}
	}

	static void up(int x, int y) {
		for (int i = x; i > -1; i--) {
			if (map[i][y] == 6)
				break;
			if (map[i][y] == 0)
				map[i][y] = -1;
		}
	}

	static void down(int x, int y) {
		for (int i = x; i < N; i++) {
			if (map[i][y] == 6)
				break;
			if (map[i][y] == 0)
				map[i][y] = -1;
		}  
	}

	static void left(int x, int y) {
		for (int j = y; j > -1; j--) {
			if (map[x][j] == 6)
				break;
			if (map[x][j] == 0)
				map[x][j] = -1;
		}
	}

	static void right(int x, int y) {
		for (int j = y; j < M; j++) {
			if (map[x][j] == 6)
				break;
			if (map[x][j] == 0)
				map[x][j] = -1;
		}
	}

	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
