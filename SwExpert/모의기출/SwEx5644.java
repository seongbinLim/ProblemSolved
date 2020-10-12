package 모의기출;
import java.util.Arrays;
import java.util.Scanner;

public class SwEx5644 {
	static class BC {
		int x, y;
		int c, p;

		public BC(int x, int y, int c, int p) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int M, A;
	static BC[] bc;
	static int[][] route;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			M = sc.nextInt(); // 이동시간
			A = sc.nextInt(); // bc의 갯수

			route = new int[2][M]; //A, B경로
			for (int i = 0; i < M; i++) {
				route[0][i] = sc.nextInt();
			}
			for (int i = 0; i < M; i++) {
				route[1][i] = sc.nextInt();
			}
			
			int sA = 0, sB = 0;
			bc = new BC[A];
			for (int i = 0; i < A; i++) {
				int y = sc.nextInt() - 1; //arr[0] 부터 시작
				int x = sc.nextInt() - 1; //arr[0] 부터 시작
				int c = sc.nextInt();
				int p = sc.nextInt();
				bc[i] = new BC(x, y, c, p);
				//시작점이 충전가능한 경우
				if (distance(x, y, 0, 0) <= c)
					sA = Math.max(sA, p);
				if (distance(x, y, 9, 9) <= c)
					sB = Math.max(sB, p);

			}
			max = Integer.MIN_VALUE;
			dfs(0, new Point(0, 0), new Point(9, 9), sA+sB);
			System.out.println("#" + t + " " + max);
		}
	}

	static int max;
	static int[][] dirs = { { 0, 0 }, { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	static void dfs(int time, Point pA, Point pB, int total) {
		//System.out.println(time + " : " + pA.charge + ", " + pB.charge);
		if (time == M) {
			max = Math.max(max, total);
			return;
		}

		int dirA = route[0][time];
		int Ax = pA.x + dirs[dirA][0];
		int Ay = pA.y + dirs[dirA][1];

		int dirB = route[1][time];
		int Bx = pB.x + dirs[dirB][0];
		int By = pB.y + dirs[dirB][1];

		boolean[] okA = new boolean[A];
		boolean[] okB = new boolean[A];
		boolean inA = false;
		boolean inB = false;
		for (int i = 0; i < A; i++) {
			if (distance(bc[i].x, bc[i].y, Ax, Ay) <= bc[i].c) {
				inA = true;
				okA[i] = true;
			}
			if (distance(bc[i].x, bc[i].y, Bx, By) <= bc[i].c) {
				inB = true;
				okB[i] = true;
			}
		}

		int max = 0;

		if (inA && inB) {
			for (int i = 0; i < A; i++) {
				for (int j = 0; j < A; j++) {
					if (okA[i] && okB[j]) {
						if (i == j) {
							if (max < bc[i].p) {
								max = bc[i].p;
							}
						} else {
							if (max < bc[i].p + bc[j].p) {
								max = bc[i].p + bc[j].p;
							}
						}
					}
				}
			}
		} else {
			for (int i = 0; i < A; i++) {
				if (okA[i])
					max = Math.max(max, bc[i].p);
				if (okB[i])
					max = Math.max(max, bc[i].p);
			}
		}
		
		Point nA = new Point(Ax, Ay);
		Point nB = new Point(Bx, By);

		dfs(time + 1, nA, nB, total+max);
	}

	static int distance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

}
