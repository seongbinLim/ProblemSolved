package done;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BackJoon4179 {
	static int R;
	static int C;
	static char[][] map;

	static class Man {
		int r;
		int c;
		int time;

		public Man(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}

	static class Fire {
		int r;
		int c;

		public Fire(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static Queue<Man> queueMan;
	static boolean[][] visitedMan;
	static Queue<Fire> queueFire; // visited 배열 없어도 F가 아닌 곳을 가면 된다

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();

		map = new char[R][C];
		visitedMan = new boolean[R][C];

		queueMan = new LinkedList<>();
		queueFire = new LinkedList<>();

		for (int r = 0; r < R; r++) {
			String s = sc.next();
			for (int c = 0; c < C; c++) {
				map[r][c] = s.charAt(c);
				if (map[r][c] == 'J') {
					map[r][c] = '.';
					queueMan.add(new Man(r, c, 0));
					visitedMan[r][c] = true;
				} else if (map[r][c] == 'F') {
					queueFire.add(new Fire(r, c));
				}
			}
		}
		bfs();
	}

	static int[] dr = { -1, +1, 0, 0 };
	static int[] dc = { 0, 0, -1, +1 };

	private static void bfs() {
		while (!queueMan.isEmpty()) {
			if (!queueFire.isEmpty())
				updateFire();
			int size = queueMan.size();
			for (int i = 0; i < size; i++) {
				Man man = queueMan.poll();

				if (man.r == 0 || man.r == R - 1 || man.c == 0 || man.c == C - 1) {
					System.out.println(man.time + 1);
					return;
				}


				for (int dir = 0; dir < 4; dir++) {
					int nr = man.r + dr[dir];
					int nc = man.c + dc[dir];

					if (nr < 0 || nr >= R || nc < 0 || nc >= C)
						continue;
					if (map[nr][nc] == 'F' || map[nr][nc] == '#' || visitedMan[nr][nc])
						continue;

					queueMan.add(new Man(nr, nc, man.time + 1));
					visitedMan[nr][nc] = true;
				}
			}		
		}
		
		System.out.println("IMPOSSIBLE");
		return;
	}

	private static void updateFire() {
		int size = queueFire.size();
		for (int i = 0; i < size; i++) {
			Fire fire = queueFire.poll();

			for (int dir = 0; dir < 4; dir++) {
				int nr = fire.r + dr[dir];
				int nc = fire.c + dc[dir];

				if (nr < 0 || nr >= R || nc < 0 || nc >= C)
					continue;
				if (map[nr][nc] == 'F' || map[nr][nc] == '#')
					continue;
				map[nr][nc] = 'F';
				queueFire.add(new Fire(nr, nc));
			}
		}
	}

}
