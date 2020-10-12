package done;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BackJoon1600_last {
	static int W, H;
	static int[][] map;
	static boolean[][][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();
		map = new int[W][H];
		visited = new boolean[W][H][K + 1];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(0, 0, 0, 0));
		visited[0][0][0] = true;

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node.r == H - 1 && node.c == W - 1) {
				System.out.println(node.cnt);
				System.exit(0);
			}
			// k가 유효하다면 12방, 아니라면 4방

			for (int i = 0; i < (node.k < K ? 12 : 4); i++) {
				int nr = node.r + dr[i];
				int nc = node.c + dc[i];
				int nk = (i >= 4 ? node.k + 1 : node.k);
				int ncnt = node.cnt + 1;

				// 바깥세상이면 제외
				if (nr > -1 && nc > -1 && nr < H && nc < W)
					continue;
				// 장애물이거나 같은 k회 사용으로 도달한 적이 있는 곳이면 제끼고
				if (map[nr][nc] == 1 || visited[nr][nc][nk])
					continue;
				visited[nr][nc][nk] = true;
				queue.add(new Node(nr, nc, nk, ncnt));
			}
		}
		System.out.println(-1);

	}

	static int[] dr = { -1, 0, 1, 0, -2, -2, -1, 1, 2, 2, 1, -1 };
	static int[] dc = { 0, 1, 0, -1, -1, 1, 2, 2, 1, -1, -2, -2 };

	static class Node {
		int r, c, k, cnt;
		Node(int r, int c, int k, int cnt) {
			this.r = r;
			this.c = c;
			this.k = k;
			this.cnt = cnt;
		}
	}

}
