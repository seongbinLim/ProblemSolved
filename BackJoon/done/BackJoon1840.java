package done;
import java.util.ArrayList;
import java.util.Scanner;

public class BackJoon1840 {
	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static final int number = 3;
	static int[][] s;
	static ArrayList<Point> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		s = new int[number][number];
		list = new ArrayList<>();

		for (int i = 0; i < number; i++) {
			for (int j = 0; j < number; j++) {
				s[i][j] = sc.nextInt();
				if (s[i][j] == 0)
					list.add(new Point(i, j));
			}
		}

		dfs(0);

	}

	static void dfs(int idx) {
		if (idx == list.size()) {
			if (isSudoku()) {
				for (int i = 0; i < number; i++) {
					for (int j = 0; j < number; j++) {
						System.out.print(s[i][j] + " ");
					}
					System.out.println();
				}
				System.exit(0);
			}
			
			System.out.println("NO SUDOKU");
			for (int i = 0; i < number; i++) {
				for (int j = 0; j < number; j++) {
					System.out.print(s[i][j] + " ");
				}
				System.out.println();
			}
            return;
		}

		for (int i = 1; i <= number; i++) {
			Point p = list.get(idx);
			s[p.x][p.y] = i;
			if (isSudoku(p.x, p.y)) {
				dfs(idx + 1); 
				s[p.x][p.y] = 0;
			}
			
			System.out.println(idx + "NO SUDOKU");
			for (int m = 0; m < number; m++) {
				for (int j = 0; j < number; j++) {
					System.out.print(s[m][j] + " ");
				}
				System.out.println();
			}
		}

	}

	static boolean isSudoku() {
		for (int i = 0; i < number; i++) {
			boolean[] num = new boolean[number+1];
			boolean[] num1 = new boolean[number+1];
			for (int j = 0; j < number; j++) {
				num[s[i][j]] = true;
				num1[s[j][i]] = true;
			}
			for (int j = 1; j < number+1; j++) {
				if (!num[j] || !num1[j]) {
					return false;
				}
			}
		}
		/*
		for (int m = 0; m < number; m = m + 3) {
			boolean[] num = new boolean[number+1];
			boolean[] num1 = new boolean[number+1];
			boolean[] num2 = new boolean[number+1];
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
		*/

		return true;
	}

	static boolean isSudoku(int x, int y) {
		int[] num = new int[number+1];
		int[] num2 = new int[number+1];
		for (int i = 0; i < number; i++) {
			num[s[x][i]]++;
			num2[s[i][y]]++;
		}
		for (int j = 1; j < number+1; j++) {
			if (num[j] > 1 || num2[j] > 1) {
				return false;
			}
		}
		
		/*
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
*/
		return true;
	}
}
