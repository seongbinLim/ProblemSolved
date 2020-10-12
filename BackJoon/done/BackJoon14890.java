package done;

import java.util.Arrays;
import java.util.Scanner;

public class BackJoon14890 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int L = sc.nextInt();

		int[][] map = new int[N][N];
		boolean[][] v = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int count = 0;
		for (int i = 0; i < N; i++) {
			boolean possible = true;
			for (int j = 1; j < N; j++) {
				if (map[i][j - 1] - map[i][j] == 1) {// down
					// j-1에서부터 L 사이즈 만큼 check (checking하면서 v[idx] change)
					// v[idx]가 존재하면 false
					int idx = j;
					int size = 0;
					while ((size < L)) {
						size++;
						if(idx >= N-1) break;
						if (map[i][idx] != map[i][idx + 1]) {
							break;
						}
						if (v[i][idx] || v[i][idx + 1]) {
							break;
						}

						v[i][idx] = true;
						idx++;
					}

					if (size != L) {
						possible = false;
						break;
					}
					if(L > 1)
						v[i][idx] = true;
				} else if (map[i][j - 1] - map[i][j] == -1) {// up
					int idx = j - 1;
					int size = 0;
					if(v[i][idx]) {
						System.out.println(idx);
						possible = false;
						break;
					}
					while ((size < L)) {
						size++;
						if(idx < 1) break;
						if (map[i][idx] != map[i][idx - 1]) {
							break;
						}

						if (v[i][idx] || v[i][idx - 1]) {
							break;
						}

						v[i][idx] = true;
						idx--;
					}

					if (size != L) {
						possible = false;
						break;
					} 
					if(L > 1)
						v[i][idx] = true;
				} else if (Math.abs(map[i][j - 1] - map[i][j]) > 1) {
					possible = false;
					break;
				}
			}

			if (possible)
				count++;

			System.out.println(i + " : " + count);
		}

		System.out.println("----------------------" + count);

		for (int i = 0; i < N; i++) {
			Arrays.fill(v[i], false);
		}

		for (int i = 0; i < N; i++) {
			boolean possible = true;
			for (int j = 1; j < N; j++) {
				if (map[j - 1][i] - map[j][i] == 1) {// down
					int idx = j;
					int size = 0;
					while ((size < L)) {
						size++;
						if(idx >= N-1) break;
						if (map[idx][i] != map[idx + 1][i]) {
							break;
						}
						if (v[idx][i] || v[idx + 1][i]) {
							break;
						}
						v[idx][i] = true;
						idx++;
					}

					// System.out.println(idx + " " + size + " " + L);
					if (size != L) {
						possible = false;
						break;
					}
					if(L > 1)
						v[i][idx] = true;
				} else if (map[j - 1][i] - map[j][i] == -1) {// up
					int idx = j - 1;
					int size = 0;
					if(v[i][idx]) {
						possible = false;
						break;
					}
					while ((size < L)) {
						size++;
						if(idx < 1) break;
						if (map[idx][i] != map[idx - 1][i]) {
							break;
						}

						if (v[idx][i] || v[idx - 1][i]) {
							break;
						}
						v[idx][i] = true;
						idx--;
					}

					// System.out.println(idx + " " + size);
					if (size != L) {
						possible = false;
						break;
					}
					
					if(L > 1)
						v[i][idx] = true;
				} else if (Math.abs(map[j - 1][i] - map[j][i]) > 1) {
					possible = false;
					break;
				}
			}

			if (possible)
				count++;

			System.out.println(i + " : " + count);
		}

		System.out.println(count);
	}
}
