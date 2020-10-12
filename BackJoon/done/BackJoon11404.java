package done;

import java.util.Scanner;

public class BackJoon11404 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[][] map = new int[N][N];
		int[][] dp = new int[N][N];

		for (int i = 0; i < M; i++) {
			int s = sc.nextInt() - 1;
			int e = sc.nextInt() - 1;
			int v = sc.nextInt();

			if (map[s][e] > v)
				map[s][e] = v;

			if (map[s][e] == 0)
				map[s][e] = v;
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i != j) {
						if (k != i && k != j && map[i][k] != 0 && map[k][j] != 0) {
							if (map[i][j] == 0 || (map[i][j] > map[i][k] + map[k][j]))
								map[i][j] = map[i][k] + map[k][j];
						}
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}

}
