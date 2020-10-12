package done;
import java.util.ArrayList;
import java.util.Scanner;

public class BackJoon2239 {
	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[][] s;
	static ArrayList<Point> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		s = new int[9][9];
		list = new ArrayList<>();

		for (int i = 0; i < 9; i++) {
			String str = sc.next();
			for (int j = 0; j < 9; j++) {
				s[i][j] = str.charAt(j)-'0';
				if (s[i][j] == 0)
					list.add(new Point(i, j));
			}
		}

		dfs(0);

	}

	static void dfs(int idx) {
		if (idx == list.size()) {
			if (isSudoku()) {
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						System.out.print(s[i][j]);
					}
					System.out.println();
				}
				System.exit(0);
			}
            return;
		}

		for (int i = 1; i < 10; i++) {
			Point p = list.get(idx);
			s[p.x][p.y] = i;
			if (isSudoku(p.x, p.y)) {
				dfs(idx + 1);
			}
			s[p.x][p.y] = 0;
		}

	}

	static boolean isSudoku() {
		for (int i = 0; i < 9; i++) {
			boolean[] num = new boolean[10];
			boolean[] num1 = new boolean[10];
			for (int j = 0; j < 9; j++) {
				num[s[i][j]] = true;
				num1[s[j][i]] = true;
			}
			for (int j = 1; j < 10; j++) {
				if (!num[j] || !num1[j]) {
					return false;
				}
			}
		}
		for (int m = 0; m < 9; m = m + 3) {
			boolean[] num = new boolean[10];
			boolean[] num1 = new boolean[10];
			boolean[] num2 = new boolean[10];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					num[s[m + i][j]] = true;
				}
				for (int j = 3; j < 6; j++) {
					num1[s[m + i][j]] = true;
				}
				for (int j = 6; j < 9; j++) {
					num2[s[m + i][j]] = true;
				}
			}

			for (int j = 1; j < 10; j++) {
				if (!num[j] || !num1[j] || !num2[j]) {
					return false;
				}
			}
		}

		return true;
	}

	static boolean isSudoku(int x, int y) {
		int[] num = new int[10];
		int[] num2 = new int[10];
		for (int i = 0; i < 9; i++) {
			num[s[x][i]]++;
			num2[s[i][y]]++;
		}
		for (int j = 1; j < 10; j++) {
			if (num[j] > 1 || num2[j] > 1) {
				return false;
			}
		}
		int sX = x / 3;
		int sY = y / 3;

		if (sX == 1)
			sX = 3;
		else if (sX == 2)
			sX = 6;

		if (sY == 1)
			sY = 3;
		else if (sY == 2)
			sY = 6;

		num = new int[10];
		for (int i = sX; i < sX + 3; i++) {
			for (int j = sY; j < sY + 3; j++) {
				num[s[i][j]]++;
			}
		}

		for (int j = 1; j < 10; j++) {
			if (num[j] > 1) {
				return false;
			}
		}

		return true;
	}
}
