package done;
import java.util.Arrays;
import java.util.Scanner;

public class BackJoon17136 {
	static int[][] map;
	static int[] paper;
	static int[] dx = { 1, 0 };
	static int[] dy = { 0, 1 };
	static int min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[10][10];
		paper = new int[6];

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		min = Integer.MAX_VALUE;

		DFS(0, 0);
		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}

	static void DFS(int sX, int sY) {
		int sumOfPaper = 0;
		for (int i = 1; i < paper.length; i++) {
			sumOfPaper += paper[i];
			if (paper[i] > 5)
				return;
		}

		if (sX == 10 || sY == 10) {
			min = Math.min(min, sumOfPaper);
			return;
		}

		if (map[sX][sY] == 1) {
			for (int k = 1; k < paper.length; k++) {
				if (attach(sX, sY, k)) {
					paper[k]++;
					if(sY == 9) DFS(sX+1, 0);
					else DFS(sX, sY+1);
					detach(sX, sY, k);
					paper[k]--;

				}
			}
		} else {
			if(sY == 9) DFS(sX+1, 0);
			else DFS(sX, sY+1);
		}
	}

	static void detach(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				map[i][j] = 1;
			}
		}

	}

	static boolean attach(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (i >= map.length || j >= map[i].length)
					return false;
				if (map[i][j] == 0) {
					return false;
				}
			}
		}

		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				map[i][j] = 0;
			}
		}

		//for (int i = 0; i < 10; i++)
		//	System.out.println(Arrays.toString(map[i]));
		//System.out.println("-------------------");
		return true;
	}
}
