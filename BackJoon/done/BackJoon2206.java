package done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BackJoon2206 {
	public static class Point {
		int x, y;
		int move;
		int wall;
		
		public Point(int x, int y, int move, int wall) {
			this.x = x;
			this.y = y;
			this.move = move;
			this.wall = wall;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		int[][] len = new int[N][M];

		for(int i=0; i<N; i++) {
			String input = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = input.charAt(j)-'0';
				len[i][j] = 12356789;
			}
		}
		
		int endX = N-1, endY = M-1;
		int ans = 123456789;
		len[0][0] = 1;
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0, 1, 0));

		while(!q.isEmpty()) {
			Point p = q.poll();
			if(p.x == endX && p.y == endY) {
				ans = p.move;
				break;
			}

			int[] dx = {-1,0,1,0};
			int[] dy = {0,-1,0,1};
			
			for(int i=0; i<4; i++) {
				int newX = p.x + dx[i];
				int newY = p.y + dy[i];
				
				if(newX<0 || newY<0 || newX>=N || newY>=M || len[p.x][p.y] >= len[newX][newY])
					continue;
				if(len[newX][newY] <= p.wall)
					continue;
				
				if(map[newX][newY]==0) {
					q.add(new Point(newX, newY, p.move+1, p.wall));
					len[newX][newY] = p.wall;
				}else if(map[newX][newY]==1 && p.wall==0) {
					len[newX][newY] = p.wall+1;
					q.add(new Point(newX, newY, p.move+1, p.wall+1));
				}
			}
		}		
		
		if(ans!=123456789) System.out.println(ans);
		else System.out.println(-1);
		
	}

}