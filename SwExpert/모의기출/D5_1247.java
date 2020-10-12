package 모의기출;
import java.util.Scanner;

public class D5_1247 {
	static int N;
	static int[][] customer;
	static int[] home;
	static int[] company;
	static int total;
	static boolean[] visited;

	public static void main(String[] args) {
		int tc = 10;
		Scanner sc = new Scanner(System.in);
		sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			N = sc.nextInt();
			customer = new int[N][2];
			company = new int[2];
			home = new int[2];
			visited = new boolean[N];

			company[0] = sc.nextInt();
			company[1] = sc.nextInt();
			home[0] = sc.nextInt();
			home[1] = sc.nextInt();

			for (int i = 0; i < N; i++) {
				customer[i][0] = sc.nextInt();
				customer[i][1] = sc.nextInt();
			}

			total = Integer.MAX_VALUE;

			perm(0, 0, company[0], company[1]);
			System.out.println("#"+t + " " + total);
		}

	}

	static void perm(int idx, int length, int currentX, int currentY) {
		int max = length + Math.abs(home[0] - currentX) + Math.abs(home[1] - currentY);
		if(max > total) {
			return;
		}
		if (idx == N) {
			total = max;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				int a = Math.abs(customer[i][0] - currentX) + Math.abs(customer[i][1] - currentY);
				perm(idx + 1, a+length, customer[i][0], customer[i][1]);
				visited[i] = false;
			}
		}

	}

}
