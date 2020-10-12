package D3;

import java.util.Scanner;

public class D3_상호의배틀필드 {
	static char[][] map;
	static int H;
	static int W;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int t = 1; t <= tc; t++) {
			H = sc.nextInt();
			W = sc.nextInt();
			map = new char[H][W];

			int start = -1;
			int end = -1;
			for (int i = 0; i < H; i++) {
				String tmp = sc.next();
				for (int j = 0; j < W; j++) {
					map[i][j] = tmp.charAt(j);
					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						start = i;
						end = j;
					}
				}
			}
			sc.nextInt();
			move(sc.next(), start, end);

			System.out.print("#" + t + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}

	static void move(String str, int r, int c) {
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		int dir = -1;

		if (map[r][c] == '^')
			dir = 0;
		if (map[r][c] == 'v')
			dir = 2;
		if (map[r][c] == '<')
			dir = 3;
		if (map[r][c] == '>')
			dir = 1;

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == 'S') {
				int shootX = r + dx[dir];
				int shootY = c + dy[dir];
				while (shootX > -1 && shootY > -1 && shootX < H && shootY < W && map[shootX][shootY] != '#') {
					if (map[shootX][shootY] == '*') {
						map[shootX][shootY] = '.';
						break;
					}
					shootX += dx[dir];
					shootY += dy[dir];
				}
			} else {
				if (ch == 'U') {
					dir = 0;
					map[r][c] = '^';
				} else if (ch == 'D') {
					dir = 2;
					map[r][c] = 'v';
				} else if (ch == 'L') {
					dir = 3;
					map[r][c] = '<';
				} else if (ch == 'R') {
					dir = 1;
					map[r][c] = '>';
				}
				
				r += dx[dir];
				c += dy[dir];
				if (r > -1 && c > -1 && r < H && c < W && map[r][c] == '.') {
					map[r][c] = map[r-dx[dir]][c-dy[dir]];
					map[r-dx[dir]][c-dy[dir]] = '.';
				} else {
					r -= dx[dir];
					c -= dy[dir];
				}
			}
		}

	}

}
