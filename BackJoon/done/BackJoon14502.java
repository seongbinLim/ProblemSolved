package done;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BackJoon14502 {
	static class Pos {
		int x;
		int y;

		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	};

	static int[][] map;
	static int[] sel;
	static int N;
	static int M;
	static int max;
	static ArrayList<Pos> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		int[][] arr = new int[N][M];
		list = new ArrayList<>();
		sel = new int[3];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
				if (arr[i][j] == 0)
					list.add(new Pos(i, j));

			}
		}
		max = 0;
		comb(arr, 0, 0);
		System.out.println(max);

	}

	static void comb(int[][] arr, int idx, int s_idx) {
		if (s_idx == 3) {

			int[][] map = new int[N][M];
			for(int i=0; i<N; i++) {
				map[i] = arr[i].clone();
			}
			
			for (int i = 0; i < sel.length; i++) {
				map[list.get(sel[i]).x][list.get(sel[i]).y] = 1;
			}
			
			max = Math.max(max, move(map));
			return;
		}
		
		if(idx == list.size()) return;
		
		sel[s_idx] = idx;
		comb(arr, idx+1, s_idx+1);
		comb(arr, idx+1, s_idx);

	}

	static int move(int[][] arr) {
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		Queue<Pos> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == 2)
					q.add(new Pos(i, j));
			}
		}
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			
			for(int i=0; i<4; i++) {
				int x = p.x+dr[i];
				int y = p.y+dc[i];
				
				if(x>-1 && y>-1 && x<N && y<M && arr[x][y] == 0) {
					q.add(new Pos(x,y));
					arr[x][y] = 2;
				}
			}
		}

		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					count++;
				}
			}
		}

		return count;
	}

}
