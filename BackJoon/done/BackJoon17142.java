package done;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BackJoon17142 {
	static class Point {
		int x,y,t;
		public Point(int x, int y, int t) {
			this.x = x;
			this.y = y;
			this.t = t;
		}
	}
	static int N,M;
	static int min;
	static int[][] arr;
	static ArrayList<Point> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N][N];
		list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j]==2) {
					list.add(new Point(i,j,0));
				}
			}
		}
		min = Integer.MAX_VALUE;
		pick = new int[M];
		nCr(0, 0);
		if(min==Integer.MAX_VALUE) min = -1;
		System.out.println(min);

	}
	static int[] pick;
	
	static void nCr(int cnt, int idx) {
		if(cnt==M) {
			//System.out.println(Arrays.toString(pick));
			Queue<Point> q = new LinkedList<>();
			for(int i=0; i<M; i++) {
				q.add(list.get(pick[i]));
			}
			int[][] map = new int[N][N];
			for(int i=0; i<N; i++)
				map[i] = arr[i].clone();
			bfs(q, map);
			return;
		}
		
		for(int i=idx; i<list.size(); i++) {
			pick[cnt] = i;
			nCr(cnt+1, i+1);
		}
	}
	
	static void bfs(Queue<Point> q, int[][] map) {
		if(findAll(map)) {
			min = 0;
			return;
		}
		int time = Integer.MAX_VALUE;
		boolean[][] v = new boolean[N][N];
		while(!q.isEmpty()) {
			if(findAll(map)) {
				break;
			}
			Point p = q.poll();
			int[] dx = {-1,0,1,0};
			int[] dy = {0,1,0,-1};
			for(int i=0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if(nx<0||ny<0||nx>=N||ny>=N||v[nx][ny]||map[nx][ny]==1)
					continue;
				v[nx][ny] = true;
				map[nx][ny] = -1;
				q.add(new Point(nx,ny,p.t+1));
			}
			time = p.t+1;
		}
		if(findAll(map)) {
			min = Math.min(min, time);
		}
	}
	
	static boolean findAll(int[][] map) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==0) return false;
			}
		}
		return true;
	}
}
