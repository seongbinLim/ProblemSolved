package done;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BackJoon2146 {
	static int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
	static int[][] map;
	static int N;
	static int MinDist;
	static int islandIdx;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		islandIdx = 2;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==1) {
					bfs(i,j);
					islandIdx++;
				}
			}
		}
		
		MinDist = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]>1) {
					getShortBridgeLength(i,j);
				}
			}
		}
		
		System.out.println(MinDist);

	}
	
	static void getShortBridgeLength(int row, int col) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(row, col, map[row][col], 0));
		
		boolean[][] visited = new boolean[N][N];
		visited[row][col]=true;
		
		while(!q.isEmpty()) {
			Point front = q.poll();
			
			
			if(front.d >= MinDist) {
				break;
			}
			
			for(int d=0; d<dirs.length; d++) {
				int nr = front.r + dirs[d][0];
				int nc = front.c + dirs[d][1];
				
				if(isIn(nr, nc) && !visited[nr][nc]) {
					visited[nr][nc] = true;
					//이 섬의 내륙지방
					if(map[nr][nc]==front.idx) {
						continue;
					}
					//바다 --> 다리 연결
					else if(map[nr][nc]==0) {
						q.offer(new Point(nr, nc, front.idx, front.d+1));
					}
					//다른섬
					else if(map[nr][nc]!=front.idx) {
						MinDist = Math.min(MinDist, front.d);
						return;
					}
				}
			}
		}
	}
	
	static void bfs(int row, int col) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(row, col, islandIdx));
		//방문처리
		map[row][col] = islandIdx;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int d=0; d<dirs.length;d++) {
				int nr = p.r + dirs[d][0];
				int nc = p.c + dirs[d][1];
				
				if(isIn(nr, nc) && map[nr][nc]==1) {
					map[nr][nc] = islandIdx;
					q.offer(new Point(nr, nc, islandIdx));
				}
			}
		}
	}
	
	static boolean isIn(int row, int col) {
		return 0<=row && row<N && 0<=col && col<N;
	}

	static class Point {
		int r, c, idx;
		int d;
		public Point(int r, int c, int idx) {
			super();
			this.r = r;
			this.c = c;
			this.idx = idx;
		}
		public Point(int r, int c, int idx, int d) {
			this(r, c, idx);
			this.d = d;
		}
	}
}
